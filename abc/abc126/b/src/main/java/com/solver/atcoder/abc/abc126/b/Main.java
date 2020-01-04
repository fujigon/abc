package com.solver.atcoder.abc.abc126.b;

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

    int l = Integer.valueOf(s.substring(0, 2));
    int r = Integer.valueOf(s.substring(2, 4));

    boolean lMonth = false;
    boolean rMonth = false;
    if (0 < l && l <= 12) {
      lMonth = true;
    }
    if (0 < r && r <= 12) {
      rMonth = true;
    }

    if (lMonth && rMonth) {
      os.println("AMBIGUOUS");
    } else if (lMonth) {
      os.println("MMYY");
    } else if (rMonth) {
      os.println("YYMM");
    } else {
      os.println("NA");
    }

  }
}