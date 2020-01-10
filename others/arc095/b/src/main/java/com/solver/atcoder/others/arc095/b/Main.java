package com.solver.atcoder.others.arc095.b;

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
    int[] a = new int[n];

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      max = Math.max(max, a[i]);
    }

    int lTarget = max / 2;
    int gTarget = (max + 1) / 2;

    int diff = Integer.MAX_VALUE;
    int index = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == max) continue;
      int d = Math.min(Math.abs(lTarget - a[i]), Math.abs(gTarget - a[i]));
      if (d < diff) {
        diff = d;
        index = i;
      }
    }

    os.println(max + " " + a[index]);
  }
}
