package com.solver.atcoder.others.abc088.d;

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

  private static class Point {

    int c;
    int r;

    public Point(int c, int r) {
      this.c = c;
      this.r = r;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Point point = (Point) o;
      return r == point.r &&
          c == point.c;
    }

    @Override
    public int hashCode() {
      return Objects.hash(r, c);
    }
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int h = sc.nextInt();
    int w = sc.nextInt();

    boolean[][] grid = new boolean[h][w]; // true : while (can be), false : black (blocked)

    int white = 0;
    for (int r = 0; r < h; r++) {
      String line = sc.next();
      for (int c = 0; c < w; c++) {
        grid[r][c] = line.charAt(c) == '.';
        if (grid[r][c]) white++;
      }
    }

    List<Point> path = bfs(new Point(0, 0), new Point(w - 1, h - 1), Main::travel,
        (p -> Main.predicate(p, grid)));

    if (path == null) {
      os.println(-1);
      return;
    }
    os.println(white - path.size());
  }

  private static Set<Point> travel(Point p) {
    Set<Point> toVisit = new HashSet<>();
    toVisit.add(new Point(p.c - 1, p.r));
    toVisit.add(new Point(p.c + 1, p.r));
    toVisit.add(new Point(p.c, p.r - 1));
    toVisit.add(new Point(p.c, p.r + 1));
    return toVisit;
  }

  private static boolean predicate(Point p, boolean[][] grid) {
    if (p.c < 0 || grid[0].length <= p.c) {
      return false;
    }
    if (p.r < 0 || grid.length <= p.r) {
      return false;
    }
    return grid[p.r][p.c];
  }

  private static <P> List<P> bfs(P start, P end, Function<P, Set<P>> travel,
      Predicate<P> predicate) {
    Set<P> visited = new HashSet<>();
    Queue<List<P>> queue = new LinkedList<>();
    visited.add(start);
    queue.add(Collections.singletonList(start));

    while (!queue.isEmpty()) {
      List<P> path = queue.remove();
      P head = path.get(path.size() - 1);
      Set<P> candidates = travel.apply(head);
      for (P c : candidates) {
        if (!visited.contains(c) && predicate.test(c)) {
          List<P> p = Stream.concat(path.stream(), Stream.of(c)).collect(Collectors.toList());
          queue.add(p);
          visited.add(c);
          if (c.equals(end)) {
            return p;
          }
        }
      }
    }
    return null;
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
