package com.solver.atcoder.others.abc079.d;

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
    int h = sc.nextInt();
    int w = sc.nextInt();

    int[][] c = new int[10][10];

    for (int j = 0; j < 10; j++) {
      for (int i = 0; i < 10; i++) {
        c[j][i] = sc.nextInt();
      }
    }

    // int[] t = dijkstraFrom1(c);
    int[] t = warshallFloyd(c);

    long ans = 0;
    for (int j = 0; j < h; j++) {
      for (int i = 0; i < w; i++) {
        int a = sc.nextInt();
        if (a < 0) continue;
        ans += t[a];
      }
    }
    os.println(ans);
  }

  private static int[] warshallFloyd(int[][] graph) {
    for (int i = 0; i < 10; i++) { // relay point
      for (int s = 0; s < 10; s++) {
        for (int t = 0; t < 10; t++) {
          graph[s][t] = Math.min(graph[s][t], graph[s][i] + graph[i][t]);
        }
      }
    }
    int[] d = new int[10];
    for (int s = 0; s < 10; s++) {
      d[s] = graph[s][1];
    }
    return d;
  }

  private static int[] dijkstraFrom1(int[][] graph) {
    int[] t = new int[10];
    for (int s = 0; s < 10; s++) {
      t[s] = dijkstra(s, 1, graph);
    }
    return t;
  }

  private static int dijkstra(int start, int target, int[][] graph) {
    int[] d = new int[10];
    for (int i = 0; i < 10; i++) {
      d[i] = Integer.MAX_VALUE;
    }
    d[start] = 0;
    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> d[i]));
    queue.add(start);
    while (!queue.isEmpty()) {
      int u = queue.remove();
      for (int v = 0; v < 10; v++) {
        int distance = d[u] + graph[u][v];
        if (distance < d[v]) {
          d[v] = distance;
          queue.add(v);
        }
      }
    }
    return d[target];
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
