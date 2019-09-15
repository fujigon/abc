package abc141.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Pair {
    int a;
    int b;
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    List<Queue<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Queue<Integer> queue = new LinkedList<>();
      for (int j = 0; j < n - 1; j++) {
        queue.add(sc.nextInt() - 1);
      }
      lists.add(queue);
    }

    int count = 0;
    int day = 0;
    int N = n * (n - 1) / 2;
    Queue<Pair> pairs = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      addPair(i, lists, pairs);
    }
    while (count < 2 * N) {
      if (pairs.isEmpty()) {
        os.println(-1);
        return;
      }
      Set<Integer> used = new HashSet<>();
      while (!pairs.isEmpty()) {
        Pair pair = pairs.remove();
        used.add(pair.a);
        used.add(pair.b);
      }
      for (int i : used) {
        lists.get(i).remove();
        count++;
      }

      for (int i : used) {
        addPair(i, lists, pairs);
      }
      day++;
    }
    os.println(day);
  }

  private static boolean addPair(int i, List<Queue<Integer>>lists, Queue<Pair> pairs) {
    if (lists.get(i).isEmpty()) return false;
    int j = lists.get(i).peek();
    if (lists.get(j).isEmpty()) return false;
    if (lists.get(j).peek() != i) return false;
    Pair pair = new Pair();
    pair.a = i;
    pair.b = j;
    pairs.add(pair);
    return true;
  }
}