package com.solver.atcoder.others.sumitrust2019.e;

import java.io.InputStream;
import java.io.IOException;
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
    int n = sc.nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    int[] standing = new int[n + 1];
    standing[0] = 3;
    long ans = 1;
    for (int i = 0; i < n; i++) {
      ans *= standing[a[i]];
      ans %= MOD;
      standing[a[i]]--;
      standing[a[i]+1]++;
    }
    os.println(ans);
  }

  private static class FermatCombination {

    private final long mod;

    private final long[] fact;

    FermatCombination(int size, long mod) {
      this.mod = mod;
      this.fact = new long[size + 1];
      fact[0] = 1;
      for (int i = 1; i <= size; i++) {
        fact[i] = (fact[i - 1]) * i % mod;
      }
    }

    private long pow(long x, long n) {
      if (n == 1) return x;
      if (n == 0) return 1;
      return (pow(x * x % mod, n / 2) % mod * pow(x, n % 2)) % mod;
    }

    private long inverse(long x) {
      return pow(x, mod - 2) % mod;
    }

    private long factorial(int x) {
      return fact[x];
    }

    private long combination(int n, int r) {
      return ((factorial(n) * inverse(factorial(n - r))) % mod * inverse(factorial(r))) % mod;
    }

    private long repeatedCombination(int n, int r) {
      return combination(n + r - 1, r);
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
