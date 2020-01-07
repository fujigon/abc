package com.solver.atcoder.others.abc138.d;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Node {

    public Node(int node) {
      this.node = node;
    }

    int node;

    long value = 0L;

    Set<Node> children = new HashSet<>();
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int q = sc.nextInt();

    Node[] nodes = new Node[n + 1];

    for (int i = 1; i <= n; i++) {
      nodes[i] = new Node(i);
    }

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      nodes[a].children.add(nodes[b]);
      nodes[b].children.add(nodes[a]);
    }

    Node root = nodes[1];

    for (int i = 0; i < q; i++) {
      int p = sc.nextInt();
      long x = sc.nextInt();
      nodes[p].value += x;
    }

    traversal(root, null, 0);

    os.println(Arrays.stream(nodes, 1, nodes.length).map(node -> String.valueOf(node.value))
        .collect(Collectors.joining(" ")));
  }

  private static void traversal(Node root, Node parent, long inherit) {
    root.value += inherit;
    for (Node child : root.children) {
      if (child == parent) {
        continue;
      }
      traversal(child, root, root.value);
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
