package abc.abc149.f;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  
  public static void main(String[] args) {
    solve(System.in, System.out);
  }
  
  private static class Node {
    
    Node(int value) {
      this.value = value;
    }
    
    int value;
    
    int maxDepth;
    
    Node parent = null;
    
    Set<Node> children = new HashSet<>();
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    
    // takahashi
    int u = sc.nextInt() - 1;
    // aoki
    int v = sc.nextInt() - 1;
    
    Map<Integer, Set<Integer>> tree = new HashMap<>();
    
    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;

      Set<Integer> aNeighbors = tree.getOrDefault(a, new HashSet<>());
      aNeighbors.add(b);
      tree.put(a, aNeighbors);

      Set<Integer> bNeighbors = tree.getOrDefault(b, new HashSet<>());
      bNeighbors.add(a);
      tree.put(b, bNeighbors);
    }

    // construct tree
    Map<Integer, Node> nodes = new HashMap<>();
    Node aoki = construct(v, tree, nodes);
    Node taka = nodes.get(u);
    
    int turn = 0;
    
    // find distance between aoki and taka
    int distance = findTaka(aoki, taka, new HashSet<>());
    
    if (distance > 0) {
      int goParent = (distance - 1) / 2;
      turn += goParent;

      for (int i = 0; i < goParent; i++) {
        taka = taka.parent;
      }

      turn += taka.maxDepth - 1;

      turn += (distance - 2 * goParent) / 2;
    }
    
    os.println(turn);
  }
  
  private static Node construct(int value, Map<Integer, Set<Integer>> tree, Map<Integer, Node> visited) {
    if (visited.containsKey(value)) return visited.get(value);
    Node node = new Node(value);
    visited.put(value, node);
    
    int maxDepth = 0;
    
    for (int next : tree.get(value)) {
      Node child = construct(next, tree, visited);
      maxDepth = Math.max(child.maxDepth, maxDepth);
      child.parent = node;
      node.children.add(child);
    }
    node.maxDepth = maxDepth + 1;
    return node;
  }
  
  private static int findTaka(Node start, Node taka, Set<Node> visited) {
    if (start == taka) return 0;
    visited.add(start);
    for (Node child : start.children) {
      if (visited.contains(child)) continue;
      int find = findTaka(child, taka, visited) + 1;
      if (find > 0) return find;
    }
    return -1;
  }
  
}