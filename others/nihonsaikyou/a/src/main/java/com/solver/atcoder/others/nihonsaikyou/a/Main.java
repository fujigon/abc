package com.solver.atcoder.others.nihonsaikyou.a;

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
    int M = sc.nextInt();
    int D = sc.nextInt();

    int count = 0;
    for (int m = 1; m <= M; m++) {
      for (int d = 1; d <= D; d++) {
        int d10 = d / 10;
        int d1 = d % 10;
        if (d10 >= 2 && d1 >= 2 && m == d10 * d1) count++;
      }
    }
    os.println(count);
  }
}