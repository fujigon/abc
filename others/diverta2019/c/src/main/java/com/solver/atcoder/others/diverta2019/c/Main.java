package com.solver.atcoder.others.diverta2019.c;

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
    String[] s = new String[n];

    for (int i = 0; i < n; i++) {
      s[i] = sc.next();
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j + 2 < s[i].length(); j++) {
        if(s[i].substring(j, j + 2).equals("AB")) ans++;
      }
    }

    int bxa = 0;
    int bxx = 0;
    int xxa = 0;
    for (int i = 0; i < n; i++) {
      char st = s[i].charAt(0);
      char en = s[i].charAt(s[i].length() - 1);
      if (st == 'B' && en == 'A') bxa++;
      else if (st == 'B') bxx++;
      else if (en == 'A') xxa++;
    }

    if (bxa > 0) {
      ans += bxa - 1;
      if (xxa > 0) {
        ans++; xxa--;
      }
      if (bxx > 0) {
        ans++; bxx--;
      }
    }
    ans += Math.min(xxa, bxx);
    os.println(ans);
  }
}
