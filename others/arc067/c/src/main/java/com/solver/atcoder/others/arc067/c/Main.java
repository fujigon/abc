package com.solver.atcoder.others.arc067.c;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

  private static final long MOD = 1000000007L;

  public static void main(String[] args) {
    solve(System.in, System.out);
  }


  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    Map<Integer, Integer> factors = factorsOfFactorial(n);

    long ans = 1;
    for (int factor : factors.keySet()) {
      int occur = factors.get(factor);
      ans += ans * occur;
      ans = ans % MOD;
    }
    os.println(ans);
  }

  private static Map<Integer, Integer> factorsOfFactorial(int x) {
    Map<Integer, Integer> factorsOfFactorial = new HashMap<>();
    for (int i = 2; i <= x; i++) {
      factorsOfFactorial = merge(factorize(i), factorsOfFactorial);
    }
    return factorsOfFactorial;
  }

  private static Map<Integer, Integer> merge(Map<Integer, Integer> f1, Map<Integer, Integer> f2) {
    Map<Integer, Integer> merged = new HashMap<>();
    for (int factor : f1.keySet()) {
      merged.put(factor, merged.getOrDefault(factor, 0) + f1.get(factor));
    }
    for (int factor : f2.keySet()) {
      merged.put(factor, merged.getOrDefault(factor, 0) + f2.get(factor));
    }
    return merged;
  }

  private static Map<Integer, Integer> factorize(int x) {
    Map<Integer, Integer> factors = new HashMap<>();
    int factor = 2;
    while (x != 1) {
      while (x % factor == 0) {
        x /= factor;
        factors.put(factor, factors.getOrDefault(factor, 0) + 1);
      }
      factor++;
    }
    return factors;
  }

  private static class Scanner {

    private final InputStream is;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    Scanner(InputStream is) {
      this.is = is;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = is.read(buffer);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buffer[ptr++];
      } else {
        return -1;
      }
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
        ptr++;
      }
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      long nl = nextLong();
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
        throw new NumberFormatException();
      }
      return (int) nl;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
