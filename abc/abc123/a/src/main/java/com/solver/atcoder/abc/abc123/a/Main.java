package com.solver.atcoder.abc.abc123.a;

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
    int p[] = new int[5];
    for (int i = 0; i < p.length; i++) {
      p[i] = sc.nextInt();
    }
    int k = sc.nextInt();

    /* logic */
    if (p[4] - p[0] > k) {
      os.println(":(");
    } else {
      os.println("Yay!");
    }
  }
}