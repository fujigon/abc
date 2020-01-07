package com.solver.atcoder.others.arc043.a;

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
    long a = sc.nextLong();
    long b = sc.nextLong();

    long sum = 0;
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      long value = sc.nextLong();
      sum += value;
      min = Math.min(min, value);
      max = Math.max(max, value);
    }

    if (min == max) {
      os.println("-1");
      return;
    }

    double p = (double) b / (double) (max - min);
    double q = a - p * (double) sum / (double) n;

    os.println(p + " " + q);
  }
}
