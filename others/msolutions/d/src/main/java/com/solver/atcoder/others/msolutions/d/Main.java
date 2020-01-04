package com.solver.atcoder.others.msolutions.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    Map<Integer, Set<Integer>> tree = new HashMap<>(n);
    List<Integer> values = new ArrayList<>(n);

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      Set<Integer> set;

      set = tree.getOrDefault(a, new HashSet<>());
      set.add(b);
      tree.put(a, set);

      set = tree.getOrDefault(b, new HashSet<>());
      set.add(a);
      tree.put(b, set);
    }

    for (int i = 0; i < n; i++) {
      values.add(sc.nextInt());
    }

    Collections.sort(values);

    LinkedList<Integer> assignable = new LinkedList<>();

    // find leaves
    for (int i = 1; i <= n; i++) {
      if (tree.get(i).size() == 1) {
        assignable.add(i);
      }
    }

    int[] assigned = new int[n + 1];
    int count = 0;
    int sum = 0;
    while (!assignable.isEmpty()) {

      int assign = assignable.remove();

      assigned[assign] = values.get(count++);

      // towards root
      Set<Integer> candidates = tree.get(assign);

      sum += assigned[assign];

      for (int candidate : candidates) {
        tree.get(candidate).remove(assign);
        if (tree.get(candidate).size() == 1) { // only towards root path
          assignable.add(candidate);
        }
      }
    }

    os.println(sum - values.get(values.size() - 1));
    List<String> result = new ArrayList<>(n);
    for (int i = 1; i <= n; i++) {
      result.add(String.valueOf(assigned[i]));
    }
    os.println(String.join(" ", result));
  }
}