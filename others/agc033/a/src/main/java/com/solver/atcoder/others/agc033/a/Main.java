package com.solver.atcoder.others.agc033.a;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int h = sc.nextInt();
    int w = sc.nextInt();

    boolean[][] visited = new boolean[h][w];
    Queue<Integer> edges = new ArrayDeque<>(w * h);
    for (int r = 0; r < h; r++) {
      String line = sc.next();
      for (int c = 0; c < w; c++) {
        if (line.charAt(c) == '#') {
          int p = encode(c, r, 0, w, h);
          edges.add(p);
        }
      }
    }

    int max = Integer.MIN_VALUE;
    while (!edges.isEmpty()) {
      int e = edges.remove();
      int r = decodeR(e, w, h);
      int c = decodeC(e, w, h);

      if (visited[r][c]) continue;

      int time = decodeTime(e, w, h);
      max = Math.max(time, max);
      visited[r][c] = true;
      travel(c, r, time, w, h, visited, edges);
    }
    os.println(max);
  }

  private static boolean predicate(int c, int r, int w, int h, boolean[][] visited) {
    if (c < 0 || w <= c) {
      return false;
    }
    if (r < 0 || h <= r) {
      return false;
    }
    return !visited[r][c];
  }

  private static void travel(int c, int r, int time, int w, int h, boolean[][] visited, Collection<Integer> set) {
    if (predicate(c - 1, r, w, h, visited)) set.add(encode(c - 1, r, time + 1, w, h));
    if (predicate(c + 1, r, w, h, visited)) set.add(encode(c + 1, r, time + 1, w, h));
    if (predicate(c, r - 1, w, h, visited)) set.add(encode(c, r - 1, time + 1, w, h));
    if (predicate(c, r + 1, w, h, visited)) set.add(encode(c, r + 1, time + 1, w, h));
  }

  private static int encode(int c, int r, int times, int w, int h) {
    return times * w * h + r * w + c;
  }

  private static int decodeC(int encoded, int w, int h) {

    return (encoded % (w * h)) % w;
  }

  private static int decodeR(int encoded, int w, int h) {
    return (encoded % (w * h)) / w;
  }

  private static int decodeTime(int encoded, int w, int h) {
    return encoded / (w * h);
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
