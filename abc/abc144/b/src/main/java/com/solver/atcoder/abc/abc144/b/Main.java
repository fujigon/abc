package com.solver.atcoder.abc.abc144.b;

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

    for (int i = 1; i <= 9; i++) {
      if (n % i == 0) {
        int j = n / i;
        if (0 < j && j <= 9) {
          os.println("Yes");
          return;
        }
      }
    }
    os.println("No");
  }
}