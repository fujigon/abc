package com.solver.atcoder.others.arc095.b;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Comb {
    long n;
    long r;
    long c;

    public Comb(long n, long r) {
      this.n = n;
      this.r = r;
      c = 1;
      for (int i = 0; i < r; i++) {
        c *= (n - i);
        c /= (i + 1);
      }
    }

    private long combination() {
      return c;
    }
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    List<Integer> a = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      a.add(sc.nextInt());
    }
    Collections.sort(a);
    List<Comb> combs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int target = a.get(i) / 2;
      int j = Collections.binarySearch(a, target);
      if (j >= 0 && i != j) {
        combs.add(new Comb(a.get(i), a.get(j)));
      } else {
        j = ~j;
        if (0 <= j && j < n && i != j)
          combs.add(new Comb(a.get(i), a.get(j)));
        if (0 <= j - 1 && j - 1 < n && i != j - 1)
          combs.add(new Comb(a.get(i), a.get(j - 1)));
      }
    }
    combs.sort(Comparator.comparingLong(Comb::combination).reversed());

    os.println(combs.get(0).n  + " " + combs.get(0).r);
  }
}
