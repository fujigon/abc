package com.solver.atcoder.abc.abc135.a;

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
    int a = sc.nextInt();
    int b = sc.nextInt();
    if (Math.abs(a - b) % 2 == 0) {
      os.println(Math.min(a, b) + Math.abs(a - b) / 2);
    } else {
      os.println("IMPOSSIBLE");
    }
  }
}