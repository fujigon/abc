package com.solver.atcoder.others.joi2008yo.e;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int r = sc.nextInt();
    int c = sc.nextInt();
    boolean[][] grid = new boolean[r][c];

    for (int y = 0; y < r; y++) {
      for (int x = 0; x < c; x++) {
        grid[y][x] = sc.nextInt() == 0;
      }
    }

    int ans = 0;
    for (int i = 0; i < 1 << r; i++) {
      boolean[] flip = new boolean[r];
      for (int b = 0; b < r; b++) {
        if (((i >> b) & 1) > 0) flip[b] = true;
      }
      ans = Math.max(ans, count(grid, flip, r, c));
    }
    os.println(ans);
  }

  private static int count(boolean[][] grid, boolean[] flip, int r, int c) {
    int count = 0;
    for (int x = 0; x < c; x++) {
      int columnCount = 0;
      for (int y = 0; y < r; y++) {
        if (!flip[y] & grid[y][x] || flip[y] & !grid[y][x]) columnCount++;
      }
      count += Math.max(columnCount, r - columnCount);
    }
    return count;
  }

  private static long gcd(long m, long n) {
    if (m < n) return gcd(n, m);
    if (n == 0) return m;
    return gcd(n, m % n);
  }

  private static long lcm(long m, long n) {
    return m / gcd(m, n) * n;
  }

  private static class Modular {

    private final long mod;

    private Modular(long mod) {
      this.mod = mod;
    }

    private long inverse(long n) {
      return pow(n, mod - 2) % mod;
    }

    private long pow(long x, long n) {
      /*
      long ans = 1;
      while (n > 0) {
        if ((n & 1) == 1) {
          ans = ans * x % mod;
        }
        x = x * x % mod;
        n >>= 1;
      }
      return ans;
      */
      if (n == 0) {
        return 1;
      }
      return n % 2 == 0 ?
          pow(x * x % mod, n / 2) % mod :
          x % mod * pow(x, n - 1) % mod;
    }
  }

  private static class ModularNFixedCombination {

    private final Modular modular;
    private final long[] comb;
    private final long N;

    public ModularNFixedCombination(long N, int size, long mod) {
      this.modular = new Modular(mod);
      this.comb = new long[size + 1];
      this.N = N;

      comb[0] = 1;

      for (int i = 1; i <= size; i++) {
        comb[i] = ((comb[i - 1] * (N - (i - 1))) % mod * modular.inverse(i)) % mod;
      }
    }

    long combination(int n, int k) {
      if (n != N) {
        throw new IllegalStateException();
      }
      return comb[k];
    }

    long repeatedCombination(int n, int k) {
      return combination(n + k - 1, k);
    }
  }

  private static class ModularCombination {

    private final long fact[];
    private final long mod;
    private final Modular modular;

    public ModularCombination(int size, long mod) {
      this.fact = new long[size + 1];
      this.mod = mod;
      this.modular = new Modular(mod);

      this.fact[0] = 1;
      for (int i = 1; i <= size; i++) {
        fact[i] = (fact[i - 1] * i) % mod;
      }
    }

    private long factorial(int n) {
      return fact[n];
    }

    long combination(int n, int k) {
      return
          (
              (
                  (
                      factorial(n) * modular.inverse(factorial(n - k))
                  ) % mod
              ) * modular.inverse(factorial(k))
          ) % mod;
    }

    long repeatedCombination(int n, int k) {
      return combination(n + k - 1, k);
    }
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
