package com.solver.atcoder.others.codefestival2016qC.b;

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
    int k = sc.nextInt();
    int t = sc.nextInt();

    Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < t; i++) {
      queue.add(sc.nextInt());
    }

    while (queue.size() > 1) {
      int large1st = queue.remove();
      int large2nd = queue.remove();
      if (large1st > 1) {
        queue.add(large1st - 1);
      }
      if (large2nd > 1) {
        queue.add(large2nd - 1);
      }
    }
    if (queue.isEmpty()) {
      os.println(0);
    } else {
      os.println(queue.remove() - 1);
    }
  }
}
