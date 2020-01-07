package com.solver.atcoder.others.abc054.b;

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
    int m = sc.nextInt();
    String[] a = new String[n];
    String[] b = new String[m];

    for (int i = 0; i < n; i++) {
      a[i] = sc.next();
    }
    for (int i = 0; i < m; i++) {
      b[i] = sc.next();
    }

    for (int i = 0; i < n - m + 1; i++) {
      for (int j = 0; j < n - m + 1; j++) {
        if (check(i, j, m, a, b)) {
          os.println("Yes");
          return;
        }
      }
    }
    os.println("No");
  }

  private static boolean check(int x, int y, int m, String[] a, String[] b) {
    for (int j = 0; j < m; j++) {
      if(!a[y + j].substring(x, x + m).equals(b[j])) return false;
    }
    return true;
  }
}
