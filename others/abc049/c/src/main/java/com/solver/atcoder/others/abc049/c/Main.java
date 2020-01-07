package com.solver.atcoder.others.abc049.c;

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

    String[] words = {"dream", "dreamer", "erase", "eraser"};

    if (dfs(s, 0, words)) {
      os.println("YES");
    } else {
      os.println("NO");
    }
  }

  private static boolean dfs(String s, int index, String[] words) {
    if (index == s.length()) return true;
    boolean res = false;
    for (String w : words) {
      String t = s.substring(index, Math.min(index + w.length(), s.length()));
      if (t.equals(w)) {
        res |= dfs(s, index + w.length(), words);
      }
    }
    return res;
 }
}
