package com.solver.atcoder.others.arc033.b;

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
    int na = sc.nextInt();
    int nb = sc.nextInt();
    Set<Integer> sa = new HashSet<>();
    Set<Integer> sb = new HashSet<>();
    Set<Integer> sorb = new HashSet<>();

    for (int i = 0; i < na; i++) {
      int x = sc.nextInt();
      sa.add(x);
      sorb.add(x);
    }
    for (int i = 0; i < nb; i++) {
      int x = sc.nextInt();
      sb.add(x);
      sorb.add(x);
    }

    Set<Integer> sandb = new HashSet<>();
    for (int x : sa) {
      if (sb.contains(x)) sandb.add(x);
    }

    os.println(String.format("%.10f", ((double) sandb.size()) / ((double) sorb.size())));
  }
}
