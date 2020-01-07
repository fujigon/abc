package com.solver.atcoder.others.abc110.c;

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
    String t = sc.next();

    Character[] trans = new Character[128];

    for (int i = 0; i < s.length(); i++) {
      char sch = s.charAt(i);
      char tch = t.charAt(i);
      if (trans[tch] != null && trans[tch] != sch) {
        os.println("No");
        return;
      }
      trans[tch] = sch;
    }

    Set<Character> occur = new HashSet<>();
    for (char c = 'a'; c <= 'z'; c++) {
      if (trans[c] == null) continue;
      if (occur.contains(trans[c])) {
        os.println("No");
        return;
      }
      occur.add(trans[c]);
    }

    os.println("Yes");
  }

}
