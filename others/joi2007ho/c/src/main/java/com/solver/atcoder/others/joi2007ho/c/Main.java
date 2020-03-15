package com.solver.atcoder.others.joi2007ho.c;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

//  private static class Point {
//    int x;
//    int y;
//
//    @Override
//    public boolean equals(Object o) {
//      if (this == o) {
//        return true;
//      }
//      if (o == null || getClass() != o.getClass()) {
//        return false;
//      }
//      Point point = (Point) o;
//      return x == point.x &&
//          y == point.y;
//    }
//
//    @Override
//    public int hashCode() {
//      return Objects.hash(x, y);
//    }
//  }
//
//  static void solve(InputStream is, PrintStream os) {
//    Scanner sc = new Scanner(is);
//
//    /* read */
//    int n = sc.nextInt();
//    Set<Point> set = new HashSet<>();
//
//    for (int i = 0; i < n; i++) {
//      Point p = new Point();
//      p.x = sc.nextInt();
//      p.y = sc.nextInt();
//      set.add(p);
//    }
//
//    int ans = 0;
//    for (Point p0 : set) {
//      for (Point p1 : set) {
//        if (p0.equals(p1)) continue;
//
//        Point p2 = new Point();
//        p2.x = p1.x + (p1.y - p0.y);
//        p2.y = p1.y - (p1.x - p0.x);
//
//        Point p3 = new Point();
//        p3.x = p2.x + (p2.y - p1.y);
//        p3.y = p2.y - (p2.x - p1.x);
//
//        if (set.contains(p2) && set.contains(p3)) {
//          ans = Math.max(ans, (p1.x - p0.x) * (p1.x - p0.x) + (p1.y - p0.y) * (p1.y - p0.y));
//        }
//      }
//    }
//
//    os.println(ans);
//  }

//  private static int RESOLUTION = 100000;
//
//  static void solve(InputStream is, PrintStream os) {
//    Scanner sc = new Scanner(is);
//
//    /* read */
//    int n = sc.nextInt();
//    Set<Integer> set = new HashSet<>();
//
//    for (int i = 0; i < n; i++) {
//      int xy = sc.nextInt() * RESOLUTION + sc.nextInt();
//      set.add(xy);
//    }
//
//    int ans = 0;
//    for (int xy0 : set) {
//      for (int xy1 : set) {
//        if (xy0 == xy1) continue;
//        int x0 = xy0 / RESOLUTION;
//        int y0 = xy0 % RESOLUTION;
//        int x1 = xy1 / RESOLUTION;
//        int y1 = xy1 % RESOLUTION;
//
//        int x2 = x1 + (y1 - y0);
//        int y2 = y1 - (x1 - x0);
//        int x3 = x2 + (y2 - y1);
//        int y3 = y2 - (x2 - x1);
//
//        if (set.contains(x2 * RESOLUTION + y2) && set.contains(x3 * RESOLUTION + y3)) {
//          ans = Math.max(ans, (x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
//        }
//      }
//    }
//
//    os.println(ans);
//  }

  private static int RESOLUTION = 100000;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int xy = sc.nextInt() * RESOLUTION + sc.nextInt();
      list.add(xy);
    }

    Collections.sort(list);

    int ans = 0;
    for (int xy0 : list) {
      for (int xy1 : list) {
        if (xy0 == xy1) continue;
        int x0 = xy0 / RESOLUTION;
        int y0 = xy0 % RESOLUTION;
        int x1 = xy1 / RESOLUTION;
        int y1 = xy1 % RESOLUTION;

        int x2 = x1 + (y1 - y0);
        int y2 = y1 - (x1 - x0);
        int x3 = x2 + (y2 - y1);
        int y3 = y2 - (x2 - x1);

        if (Collections.binarySearch(list, x2 * RESOLUTION + y2) >= 0 &&
            Collections.binarySearch(list, x3 * RESOLUTION + y3) >= 0) {
          ans = Math.max(ans, (x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
        }
      }
    }

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
