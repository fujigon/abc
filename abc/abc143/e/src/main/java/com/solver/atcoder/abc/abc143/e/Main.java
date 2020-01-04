package com.solver.atcoder.abc.abc143.e;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Edge {
    int fr;
    int to;
    int cost;
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int m = sc.nextInt();
    int l = sc.nextInt();

    // key : from city, value : edge
    List<List<Edge>> lists = new ArrayList<>(n);
    for (int i = 0; i < n; i++){
      lists.add(new LinkedList<>());
    }

    // exclude the expensive edge (than L) in advance
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      int c = sc.nextInt();
      if (c <= l) {
        Edge edge1 = new Edge();
        edge1.fr = a;
        edge1.to = b;
        edge1.cost = c;
        lists.get(edge1.fr).add(edge1);

        Edge edge2 = new Edge();
        edge2.fr = b;
        edge2.to = a;
        edge2.cost = c;
        lists.get(edge2.fr).add(edge2);
      }
    }
    Move[][] dijkstras = new Move[n][];
    for (int i = 0; i < n; i++) {
      dijkstras[i] = dijkstra(i, lists, n, l);
    }

    int q = sc.nextInt();
    List<Integer> ans = new ArrayList<>(q);
    for (int i = 0; i < q; i++) {
      int s = sc.nextInt() - 1;
      int t = sc.nextInt() - 1;
      if (dijkstras[s][t] == null) {
        ans.add(-1);
      } else {
        ans.add(dijkstras[s][t].refill);
      }
    }
    os.println(ans.stream().map(String::valueOf).collect(Collectors.joining("\n")));
  }

  private static class Move implements Comparable<Move> {
    private final int max;

    int usedFuel = 0;
    int refill = 0;

    private Move(int max) {
      this.max = max;
    }

    @Override
    public int compareTo(Move other) {
      return this.refill != other.refill ? Integer.compare(this.refill, other.refill) :
              Integer.compare(this.usedFuel, other.usedFuel);
    }

    Move run(int cost) {
      Move move = new Move(max);
      move.usedFuel = usedFuel;
      move.refill = refill;
      if (max < move.usedFuel + cost) {
        move.refill++;
        move.usedFuel = 0;
      }
      move.usedFuel += cost;
      return move;
    }
  }

  private static Move[] dijkstra(int s, List<List<Edge>> edges, int n, int l) {
    Move[] d = new Move[n + 1];
    d[s] = new Move(l);
    d[s].usedFuel = 0;
    d[s].refill = 0;

    Queue<Integer> queue = new PriorityQueue<>((i1, i2) ->
            d[i1] == null ? i2 :
                    d[i2] == null ? i1 :
                            d[i1].compareTo(d[i2]));
    queue.add(s);

    while(!queue.isEmpty()) {
      int fr = queue.remove();
      for (Edge edge : edges.get(fr)) {
        int to = edge.to;
        Move alt = d[fr].run(edge.cost);
        if (d[to] == null || alt.compareTo(d[to]) < 0) {
          d[to] = alt;
          queue.add(to);
        }
      }
    }
    return d;
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
      }else{
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
    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
    public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
    public String next() {
      if (!hasNext()) throw new NoSuchElementException();
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while(isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }
    public long nextLong() {
      if (!hasNext()) throw new NoSuchElementException();
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
      while(true){
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        }else if(b == -1 || !isPrintableChar(b)){
          return minus ? -n : n;
        }else{
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }
    public int nextInt() {
      long nl = nextLong();
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
      return (int) nl;
    }
    public double nextDouble() { return Double.parseDouble(next());}
  }

}
