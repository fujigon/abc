package com.solver.atcoder.others.abc022.b;

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
    int[] count = new int[100000];

    for (int i = 0; i < n; i++) {
      count[sc.nextInt() - 1]++;
    }

    int ans = 0;
    for (int i = 0; i < 100000; i++) {
      if (count[i] >= 2) ans += count[i] - 1;
    }

    os.println(ans);
  }
}
