package com.solver.atcoder.abc.abc149.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }
  
  private static char getWinSymbol(char c) {
    switch(c) {
      case('r') : return 'p';
      case('s') : return 'r';
      case('p') : return 's';
      default : return '*';
    }
  }
  
  private static int getWinScore(int r, int s, int p, char c) {
    switch(c) {
      case('r') : return r;
      case('s') : return s;
      case('p') : return p;
      default : return 0;
    }
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int k = sc.nextInt();
    int r = sc.nextInt(); // pattern 0
    int s = sc.nextInt(); // pattern 1
    int p = sc.nextInt(); // pattern 2
    
    String t = sc.next();
    
    long ans = 0;
    for (int i = 0; i < k; i++) {
      char lastUsing = '*';
      for (int j = i; j < n; j += k) {
        char c = t.charAt(j);
        char winSymbol = getWinSymbol(c);
        if (lastUsing != winSymbol) {
          ans += getWinScore(r, s, p, winSymbol);
          lastUsing = winSymbol;
        } else {
          lastUsing = '*';
        }
      }
    }
    os.println(ans);
  }
}