package com.solver.atcoder.abc.abc130.d;

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
    long k = sc.nextLong();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextLong();
    }

    int left = 0;
    int right = 0;

    // half-open interval
    long sum = 0;
    long res = 0;
    for (left = 0; left < n; left++) {
      while (right < n && sum + a[right] < k) {
        sum += a[right];
        right++;
      }
      // left starting, left...right, left...right+1, left...right+2...left...n-1 are OK
      res += (long) (n - 1 - (right - 1));
      if (left == right) {
        sum += a[right];
        right++;
      }
      sum -= a[left];
    }
    os.println(res);
  }
}