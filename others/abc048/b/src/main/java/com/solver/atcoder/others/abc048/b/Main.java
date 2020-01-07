package com.solver.atcoder.others.abc048.b;

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
    long a = sc.nextLong();
    long b = sc.nextLong();
    long x = sc.nextLong();
    if (a > 0) {
      os.println(b / x - (a -  1) / x);
    } else {
      os.println(b / x + 1);
    }
  }
}
