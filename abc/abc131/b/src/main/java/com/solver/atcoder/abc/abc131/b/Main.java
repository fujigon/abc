package com.solver.atcoder.abc.abc131.b;

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

    int l = sc.nextInt();

    int min = Integer.MAX_VALUE;

    int sum = 0;
    for (int i = 1; i <= n; i++){
      int taste = l + i - 1;
      if (Math.abs(taste) < Math.abs(min)) {
        min = taste;
      }
      sum += taste;
    }
    os.println(sum - min);
  }
}