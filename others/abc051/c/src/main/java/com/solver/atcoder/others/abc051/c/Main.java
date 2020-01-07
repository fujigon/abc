package com.solver.atcoder.others.abc051.c;

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
    int sx = sc.nextInt();
    int sy = sc.nextInt();
    int tx = sc.nextInt();
    int ty = sc.nextInt();

    tx -= sx;
    ty -= sy;

    StringBuilder ans = new StringBuilder();

    ans.append("L");
    for (int i = 0; i < ty + 1; i++) {
      ans.append("U");
    }
    for (int i = 0; i < tx + 1; i++) {
      ans.append("R");
    }
    ans.append("D");

    for (int i = 0; i < tx; i++) {
      ans.append("L");
    }
    for (int i = 0; i < ty; i++) {
      ans.append("D");
    }

    for (int i = 0; i < tx; i++) {
      ans.append("R");
    }
    for (int i = 0; i < ty; i++) {
      ans.append("U");
    }

    ans.append("R");
    for (int i = 0; i < ty + 1; i++) {
      ans.append("D");
    }
    for (int i = 0; i < tx + 1; i++) {
      ans.append("L");
    }
    ans.append("U");

    os.println(ans.toString());
  }
}
