package com.solver.atcoder.abc.abc139.c;

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
    int[] h = new int[n];

    for (int i = 0; i < n; i++) {
      h[i] = sc.nextInt();
    }

    int i = 0;
    int count = 0;
    int max = 0;
    while (i < n) {
      while (i + 1 < n && h[i] >= h[i + 1]) {
        count++;
        i++;
      }
      max = Math.max(max, count);
      count = 0;
      i++;
    }
    os.println(max);
  }

}