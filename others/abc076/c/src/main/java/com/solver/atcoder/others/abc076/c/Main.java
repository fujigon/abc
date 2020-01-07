package com.solver.atcoder.others.abc076.c;

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

    String ans = "";

    List<String> candidate = new ArrayList<>();
    for (int i = 0; i + t.length() <= s.length(); i++) {
      if (ok(s.substring(i, i + t.length()), t)) {
        candidate.add(generateCandidate(s, t, i));
      }
    }

    candidate.sort(String::compareTo);

    if (candidate.isEmpty()) {
      os.println("UNRESTORABLE");
    } else {
      os.println(candidate.get(0));
    }
  }

  private static boolean ok(String s, String t) {
    for (int i = 0; i < t.length(); i++) {
      if (s.charAt(i) != t.charAt(i) && s.charAt(i) != '?') return false;
    }
    return true;
  }

  private static String generateCandidate(String s, String t, int start) {
    String ans = "";
    for (int i = 0; i < start; i++) {
      if (s.charAt(i) == '?') ans += "a";
      else ans += String.valueOf(s.charAt(i));
    }
    ans += t;
    for (int i = start + t.length(); i < s.length(); i++) {
      if (s.charAt(i) == '?') ans += "a";
      else ans += String.valueOf(s.charAt(i));
    }
    return ans;
  }
}
