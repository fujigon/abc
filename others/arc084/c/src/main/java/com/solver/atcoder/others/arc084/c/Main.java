package com.solver.atcoder.others.arc084.c;

import java.io.InputStream;
import java.io.IOException;
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
    Integer[] a = new Integer[n];
    Integer[] b = new Integer[n];
    Integer[] c = new Integer[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      c[i] = sc.nextInt();
    }
    Arrays.sort(a);
    Arrays.sort(b);
    Arrays.sort(c);

    long ans = 0;

    for (int m = 0; m < n; m++) {
      long pattern = 1;
      int l = Arrays.binarySearch(c, b[m], new UpperBoundComparator<>());
      if (l < 0) {
        l = ~l;
      }
      pattern *= n - l;

      int h = Arrays.binarySearch(a, b[m], new LowerBoundComparator<>());
      if (h < 0) {
        h = ~h;
      }
      pattern *= h;

      ans += pattern;
    }
    os.println(ans);
  }

  private static class LowerBoundComparator<T extends Comparable<? super T>>
      implements Comparator<T>
  {
    public int compare(T x, T y)
    {
      return (x.compareTo(y) >= 0) ? 1 : -1;
    }
  }

  private static class UpperBoundComparator<T extends Comparable<? super T>>
      implements Comparator<T>
  {
    public int compare(T x, T y)
    {
      return (x.compareTo(y) > 0) ? 1 : -1;
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
