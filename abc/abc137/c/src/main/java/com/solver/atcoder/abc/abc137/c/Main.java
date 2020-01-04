package com.solver.atcoder.abc.abc137.c;

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
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String s = sc.next();
      List<String> list = new ArrayList<>(s.length());
      for (int j = 0; j < s.length(); j++) {
        list.add("" + s.charAt(j));
      }
      Collections.sort(list);
      String sorted = String.join("", list);
      map.put(sorted, map.getOrDefault(sorted, 0) + 1);
    }

    long ans = 0;
    for (String s : map.keySet()) {
      int occur = map.get(s);
      if (occur > 1) {
        ans += combination(occur, 2);
      }
    }
    os.println(ans);
  }

  private static long combination(long n , long k) {
    long ans = 1;
    for (long i = 1; i <= k; i++) {
      ans *= (n - i + 1);
      ans /= i;
    }
    return ans;
  }
}