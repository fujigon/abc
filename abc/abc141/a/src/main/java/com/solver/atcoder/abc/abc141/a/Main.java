package com.solver.atcoder.abc.abc141.a;

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
    String s = sc.next();
    if (s.equals("Sunny")) {
      os.println("Cloudy");
    } else if (s.equals("Cloudy")) {
      os.println("Rainy");
    } else {
      os.println("Sunny");
    }
  }
}