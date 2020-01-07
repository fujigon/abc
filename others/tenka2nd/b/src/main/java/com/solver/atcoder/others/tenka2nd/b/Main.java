package com.solver.atcoder.others.tenka2nd.b;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  private static final long MOD = 998244353;

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int[] d = new int[n];
    for (int i = 0; i < n; i++) {
      d[i] = sc.nextInt();
    }

    int[] hist = new int[n];
    for (int i = 0; i < n; i++) {
      hist[d[i]]++;
    }

    os.println(solve(n, d, hist));
  }

  private static long solve(int n, int d[], int hist[]) {
    if (d[0] != 0) return 0;
    if (hist[0] > 1) return 0;


    int last = 1;
    long ans = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < hist[i]; j++) {
        ans = ans * last % MOD;
      }
      last = hist[i];
    }
    return ans;
  }
}
