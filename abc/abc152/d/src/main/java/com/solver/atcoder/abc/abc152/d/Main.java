package com.solver.atcoder.abc.abc152.d;

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
    int n = sc.nextInt();

    int[][] hist = new int[10][10]; // first-digit, last-digit
    for (int a = 1; a <= n; a++) {
      int lDigit = a % 10;
      int fDigit = a;
      while (fDigit >= 10) {
        fDigit /= 10;
      }

      hist[fDigit][lDigit]++;
    }

    long ans = 0;

    for (int f = 1; f < 10; f++) {
      for (int l = 1; l < 10; l++) {
        ans += hist[f][l] * hist[l][f];
      }
    }
    os.println(ans);
  }

  private static class GridPointEncoder implements Encoder<GridPoint> {

    public GridPointEncoder(int h, int w) {
      this.h = h;
      this.w = w;
    }

    private final int h;
    private final int w;

    @Override
    public int num() {
      return w * h;
    }

    @Override
    public int encode(GridPoint from) {
      return w * from.r + from.c;
    }

    @Override
    public GridPoint decode(int from) {
      return new GridPoint(from / w, from % w);
    }
  }

  private static class GridPoint implements Encoded<GridPoint> {

    private final int r;
    private final int c;

    public GridPoint(int r, int c) {
      this.r = r;
      this.c = c;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      GridPoint gridPoint = (GridPoint) o;
      return r == gridPoint.r &&
          c == gridPoint.c;
    }

    @Override
    public int hashCode() {
      return Objects.hash(r, c);
    }
  }

  private static class VerticalHorizontalNeighborGridPointGraph extends GridPointGraph {

    private final boolean[][] grid;

    private final Predicate<GridPoint> predicate = this::predicate;
    private int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public VerticalHorizontalNeighborGridPointGraph(int h, int w, boolean[][] grid) {
      super(h, w);
      this.grid = grid;
    }

    private boolean predicate(GridPoint p) {
      if (p.r < 0 || h <= p.r) {
        return false;
      }
      if (p.c < 0 || w <= p.c) {
        return false;
      }
      return grid[p.r][p.c];
    }

    private Set<Edge<GridPoint>> neighbors(GridPoint from) {

      return Arrays.stream(moves)
          .map(move -> new GridPoint(from.r + move[0], from.c + move[1]))
          .filter(predicate)
          .map(to -> new ConstantWeightEdge<>(from, to))
          .collect(Collectors.toSet());
    }

    @Override
    public Set<Edge<GridPoint>> getEdges(GridPoint from) {
      if (predicate.test(from)) {
        return neighbors(from);
      } else {
        return Collections.emptySet();
      }
    }
  }

  private static abstract class GridPointGraph extends EncodedGraph<GridPoint> {

    public GridPointGraph(int h, int w) {
      super(new GridPointEncoder(h, w));
      this.h = h;
      this.w = w;

      for (int r = 0; r < h; r++) {
        for (int c = 0; c < w; c++) {
          nodes.add(new GridPoint(r, c));
        }
      }
    }

    protected final int h;
    protected final int w;

    protected final Set<GridPoint> nodes = new HashSet<>();

    @Override
    public Set<GridPoint> getVertexes() {
      return nodes;
    }
  }

  private static interface Encoded<E extends Encoded> {

  }

  private static interface Encoder<E extends Encoded> {

    int num();

    int encode(E from);

    E decode(int from);
  }

  private static abstract class EncodedGraph<V extends Encoded<V>> implements Graph<V> {

    public EncodedGraph(Encoder<V> encoder) {
      this.encoder = encoder;
      this.delegate = new IntVertexGraph() {
        @Override
        public Set<Integer> getVertexes() {
          return EncodedGraph.this.getVertexes().stream()
              .map(encoder::encode)
              .collect(Collectors.toSet());
        }

        @Override
        public Set<Edge<Integer>> getEdges(Integer from) {
          return EncodedGraph.this.getEdges(encoder.decode(from)).stream()
              .map(e -> new Edge<>(encoder.encode(e.getFrom()), encoder.encode(e.getTo()),
                  e.getWeight()))
              .collect(Collectors.toSet());
        }
      };
    }

    private final Encoder<V> encoder;
    private final IntVertexGraph delegate;

    @Override
    public Query<V> query() {
      return new Query<V>() {

        private final Query<Integer> delegate = EncodedGraph.this.delegate.query();

        @Override
        public VertexPath<V> shortestPath(V begin, V end) {
          VertexPath<Integer> path = delegate
              .shortestPath(encoder.encode(begin), encoder.encode(end));
          if (path == null) {
            return null;
          }
          return new EfficientVertexPath<>(encoder.decode(path.getBegin()),
              encoder.decode(path.getEnd()), path.getWeight());
        }
      };
    }
  }

  private static abstract class IntVertexGraph implements Graph<Integer> {

    private static class BfsQuery implements Query<Integer> {

      final Graph<Integer> graph;

      private BfsQuery(Graph<Integer> graph) {
        this.graph = graph;
      }

      @Override
      public VertexPath<Integer> shortestPath(Integer begin, Integer end) {
        Set<Integer> visited = new HashSet<>();
        Queue<VertexPath<Integer>> queue = new ArrayDeque<>();
        queue.add(new EfficientVertexPath<>(begin));
        visited.add(begin);

        while (!queue.isEmpty()) {
          VertexPath<Integer> path = queue.remove();
          Integer head = path.getEnd();

          Set<Edge<Integer>> candidates = graph.getEdges(head);
          if (head.equals(end)) {
            return path;
          }
          for (Edge<Integer> c : candidates) {
            if (!visited.contains(c.getTo())) {
              VertexPath<Integer> p = new EfficientVertexPath<>(path, c);
              queue.add(p);
              visited.add(c.getTo());
            }
          }
        }
        return null;
      }
    }

    private static class WarshallFloydQuery implements Query<Integer> {

      private final Graph<Integer> graph;

      private VertexPath<Integer>[][] shortest;

      private WarshallFloydQuery(Graph<Integer> graph) {
        this.graph = graph;

        Set<Integer> nodes = graph.getVertexes();

        shortest = new VertexPath[nodes.size()][nodes.size()];

        for (int from : nodes) {
          Set<Edge<Integer>> edges = graph.getEdges(from);
          for (Edge<Integer> e : edges) {
            shortest[e.getFrom()][e.getTo()] = new EfficientVertexPath<>(e);
          }
          shortest[from][from] = new EfficientVertexPath<>(from);
        }

        for (int relay : nodes) {
          for (int from : nodes) {
            for (int dest : nodes) {
              VertexPath<Integer> pathA = shortest[from][relay];
              VertexPath<Integer> pathB = shortest[relay][dest];
              if (pathA != null && pathB != null) {
                VertexPath<Integer> path = pathA.append(pathB);
                if (shortest[from][dest] == null || path.getWeight() < shortest[from][dest]
                    .getWeight()) {
                  shortest[from][dest] = path;
                }
              }
            }
          }
        }
      }

      @Override
      public VertexPath<Integer> shortestPath(Integer begin, Integer end) {
        return shortest[begin][end];
      }
    }

    @Override
    public Query<Integer> query() {
      return new WarshallFloydQuery(this);
      // return new BfsQuery(this);
    }
  }

  private static interface Graph<V> {

    static class Edge<V> {

      public Edge(V from, V to, long weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
      }

      private final V from;

      private final V to;
      private final long weight;


      V getFrom() {
        return from;
      }

      V getTo() {
        return to;
      }

      long getWeight() {
        return weight;
      }
    }

    static class ConstantWeightEdge<V> extends Edge<V> {

      public ConstantWeightEdge(V from, V to) {
        super(from, to, 1);
      }
    }

    Set<V> getVertexes();

    Set<Edge<V>> getEdges(V from);

    static interface VertexPath<V> {

      V getBegin();

      V getEnd();

      long getWeight();

      VertexPath<V> append(VertexPath<V> other);
    }

    Query<V> query();

    static interface Query<V> {

      VertexPath<V> shortestPath(V begin, V end);
    }

    static class EfficientVertexPath<V> implements VertexPath<V> {

      final V begin;
      final V end;
      final long weight;

      public EfficientVertexPath(V begin) {
        this.begin = begin;
        this.end = begin;
        this.weight = 0;
      }

      public EfficientVertexPath(V begin, V end, long weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
      }

      public EfficientVertexPath(Edge<V> edge) {
        this.begin = edge.getFrom();
        this.end = edge.getTo();
        this.weight = edge.getWeight();
      }

      public EfficientVertexPath(VertexPath<V> path, Edge<V> append) {
        this.begin = path.getBegin();
        if (!path.getEnd().equals(append.getFrom())) {
          throw new IllegalStateException("not correct edge.");
        }
        this.end = append.getTo();
        this.weight = path.getWeight() + append.getWeight();
      }

      public EfficientVertexPath(VertexPath<V> pathA, VertexPath<V> pathB) {
        this.begin = pathA.getBegin();
        if (!pathA.getEnd().equals(pathB.getBegin())) {
          throw new IllegalStateException("not correct edge.");
        }
        this.end = pathB.getEnd();
        this.weight = pathA.getWeight() + pathB.getWeight();
      }

      @Override
      public V getBegin() {
        return begin;
      }

      @Override
      public V getEnd() {
        return end;
      }

      @Override
      public long getWeight() {
        return weight;
      }

      @Override
      public VertexPath<V> append(VertexPath<V> other) {
        return new EfficientVertexPath<>(this, other);
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        EfficientVertexPath<?> that = (EfficientVertexPath<?>) o;
        return weight == that.weight &&
            Objects.equals(begin, that.begin) &&
            Objects.equals(end, that.end);
      }

      @Override
      public int hashCode() {
        return Objects.hash(begin, end, weight);
      }
    }
  }

  private static class FermatCombination {

    private long fact[];
    private long mod;

    public FermatCombination(int size, long mod) {
      this.fact = new long[size + 1];
      this.mod = mod;

      this.fact[0] = 1;

      for (int i = 1; i <= size; i++) {
        fact[i] = (fact[i - 1] * i) % mod;
      }
    }

    private long factorial(int n) {
      return fact[n];
    }

    private long inverse(long n) {
      return pow(n, mod - 2) % mod;
    }

    private long pow(long x, long n) {
      long ans = 1;
      while (n > 0) {
        if ((n & 1) == 1) {
          ans = ans * x % mod;
        }
        x = x * x % mod;
        n >>= 1;
      }
      return ans;
    }

    long combination(int n, int k) {
      long ans = 1;
      ans *= factorial(n);
      ans %= mod;
      ans *= inverse(factorial(n - k));
      ans %= mod;
      ans *= inverse(factorial(k));
      ans %= mod;
      return ans;
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
