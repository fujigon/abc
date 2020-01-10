package com.solver.atcoder.others.abc147.d;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    long[] a = new long[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextLong();
    }

    // bit[index][bit]
    boolean[][] bit = new boolean[n][60];

    for (int i = 0; i < n; i++) {
      for (int b = 0; b < 60; b++) {
        bit[i][b] = ((a[i] >> b) & 1) == 1;
      }
    }

    int[][] culm = new int[n + 1][60];
    for (int i = 0; i < n; i++) {
      for (int b = 0; b < 60; b++) {
        culm[i + 1][b] = culm[i][b] + (bit[i][b] ? 1 : 0);
      }
    }

    long ans = 0;
    for (int i = 0; i < n; i++) {
      for (int b = 0; b < 60; b++) {
        // occurrence num of 1-bit at b-th bit in a [i + 1, n)
        int bit1 = culm[n][b] - culm[i + 1][b];
        int bit0 = n - (i + 1) - bit1;
        if (bit[i][b]) {
          ans += (((1L << b) % MOD) * bit0) % MOD;
        } else {
          ans += (((1L << b) % MOD) * bit1) % MOD;
        }
        ans %= MOD;
      }
    }
    ans %= MOD;
    os.println(ans);
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
