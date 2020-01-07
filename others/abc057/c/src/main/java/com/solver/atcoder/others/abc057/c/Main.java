package com.solver.atcoder.others.abc057.c;

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
    long n = sc.nextLong();

    long sqrtn = (long) Math.sqrt(n);
    int min = Integer.MAX_VALUE;
    for (long a = 1; a <= sqrtn; a++) {
      long b = n / a;
      if (a * b != n) continue;
      min = Math.min(min, Math.max(digit(a), digit(b)));
    }
    os.println(min);
  }

  private static int digit(long x) {
    int d = 0;
    while (x > 0) {
      x /= 10;
      d++;
    }
    return d;
  }
}
