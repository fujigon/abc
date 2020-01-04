package com.solver.atcoder.abc.abc126.a;

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
    int k = sc.nextInt();

    String s = sc.next();

    String result = s.substring(0, k - 1) + s.substring(k - 1, k).toLowerCase() + s.substring(k, n);

    os.println(result);
  }
}