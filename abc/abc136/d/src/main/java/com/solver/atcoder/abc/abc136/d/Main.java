package com.solver.atcoder.abc.abc136.d;

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
    int n = s.length();
    boolean[] dir = new boolean[n]; // left false, right true

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'R')
        dir[i] = true;
    }

    int[] children = new int[n];

    int l = 0;
    int r = 1;

    do {
      // R -> L
      while(r < n && dir[l] == dir[r]) r++;
      for (int i = l; i < r; i++) {
        if ((r - i) % 2 == 1) children[r - 1]++;
        else children[r]++;
      }
      if (r == n) break;
      // reset
      l = r;
      r = r + 1;
      // L -> R
      while(r < n && dir[l] == dir[r]) r++;
      for (int i = r - 1; l <= i ; i--) {
        if ((i - l) % 2 == 1) children[l - 1]++;
        else children[l]++;
      }
      l = r;
      r = r + 1;
    } while (r < n);

    for (int i = 0; i < n - 1; i++) {
      os.print(children[i] + " ");
    }
    os.println(children[n - 1]);
  }
}