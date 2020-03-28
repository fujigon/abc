package com.solver.atcoder.abc.abc159.e;

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
    int h = sc.nextInt();
    int w = sc.nextInt();
    int k = sc.nextInt();

    boolean[][] white = new boolean[h][w];

    for (int r = 0; r < h; r++) {
      String line = sc.next();
      for (int c = 0; c < w; c++) {
        white[r][c] = line.charAt(c) == '1';
      }
    }

    long ans = Integer.MAX_VALUE;
    // how to separate
    for (int i = 0; i < (1 << h - 1); i++) {
      boolean[] split = new boolean[h];
      long operation = 0;
      for (int b = 0; b < h - 1; b++) {
        if (((i >> b) & 1) > 0) {
          split[b + 1] = true;
          operation++;
        }
      }
      operation += verticalOperation(white, split, w, h, k);
      ans = Math.min(ans, operation);
    }
    os.println(ans);
  }

  private static int verticalOperation(boolean[][] white, boolean[] split, int w, int h, int k) {

    int[] blocks = new int[h];
    int b = 0;
    for (int r = 0; r < h; r++) {
      if (split[r]) b++;
      blocks[r] = b;
    }

    b += 1;
    int[][] count = new int[b][w];
    for (int c = 0; c < w; c++) {
      for (int r = 0; r < h; r++) {
        if (white[r][c]) count[blocks[r]][c]++;
        if (count[blocks[r]][c] > k) return Integer.MAX_VALUE;
      }
    }

    int ans = 0;
    for (int c = 1; c < w; c++) {
      boolean needToSplit = false;
      for (int r = 0; r < b; r++) {
        if (count[r][c - 1] + count[r][c] > k) needToSplit = true;
      }
      if (needToSplit) {
        ans++;
      } else {
        for (int r = 0; r < b; r++) {
          count[r][c] += count[r][c - 1];
        }
      }
    }
    return ans;
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
