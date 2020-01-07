package com.solver.atcoder.others.abc033.c;

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

    int ans = 0;

    int i = 0;
    while(i < s.length()) {
      boolean zero = s.charAt(i) == '0';
      i += 2;
      while (i < s.length() && s.charAt(i - 1) == '*') {
        zero = zero || s.charAt(i) == '0';
        i += 2;
      }
      if (!zero) ans++;
    }
    os.println(ans);
  }
}
