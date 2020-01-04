package com.solver.atcoder.abc.abc129.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    String l = sc.next();
    int[] bits = new int[l.length()];
    for (int i = 0; i < l.length(); i++) {
      bits[i] = Character.getNumericValue(l.charAt(i));
    }

    int[] route = new int[l.length()];

    // find first bit
//    os.println(max);
  }

  private static Map<Integer, Long> memo = new HashMap<>();

  // all bit on
  static long routeSum(int bit) {
    if (bit == 1) return 1 + 2;
    if (memo.containsKey(bit)) return memo.get(bit);
    long ret = (3 * routeSum(bit - 1)) % MOD;
    memo.put(bit, ret);
    return ret;
  }
}