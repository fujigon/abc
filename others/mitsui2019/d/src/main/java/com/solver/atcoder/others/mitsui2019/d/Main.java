package com.solver.atcoder.others.mitsui2019.d;

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
    String s = sc.next();

    Set<String> len0 = new HashSet<>();
    len0.add("");
    Set<String> len1 = new HashSet<>();
    Set<String> len2 = new HashSet<>();
    Set<String> len3 = new HashSet<>();

    for (int i = 0; i < n; i++) {
      String c = s.substring(i, i + 1);
      for (String l2 : len2) {
        len3.add(l2 + c);
      }
      for (String l1 : len1) {
        len2.add(l1 + c);
      }
      for (String l0 : len0) {
        len1.add(l0 + c);
      }
    }
    os.println(len3.size());
  }
}
