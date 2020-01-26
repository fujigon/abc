package com.solver.atcoder.others.agc033.a;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static DistanceMemoBfsPathQuery query;
  private static Graph<Integer> graph;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int h = sc.nextInt();
    int w = sc.nextInt();

    List<Integer> blacks = new ArrayList<>();
    GridPointEncoder encoder = new GridPointEncoder(h, w);
    for (int r = 0; r < h; r++) {
      String line = sc.next();
      for (int c = 0; c < w; c++) {
        if (line.charAt(c) == '#') {
          blacks.add(encoder.encode(new GridPoint(r, c)));
        }
      }
    }

    // reduce visited cells
    graph = new VerticalHorizontalNeighborGridPointGraph(h, w,
        (r, c) -> predicate(r, c, h, w)).delegate;

    query = new DistanceMemoBfsPathQuery(graph);

    query.path(blacks, null);

    os.println(max);

  }

  private static boolean predicate(int r, int c, int h, int w) {
    return !query.visited[r * w + c];
  }

  static long max = 0L;

  private static class DistanceMemoBfsPathQuery extends BfsPathQuery {


    public DistanceMemoBfsPathQuery(Graph<Integer> graph) {
      super(graph);
    }

    @Override
    void mark(VertexPath<Integer> path, Edge<Integer> edge) {
      super.mark(path, edge);
      max = Math.max(max, path.getWeight() + edge.getWeight());
    }
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
    public Integer encode(GridPoint from) {
      if (from == null) {
        return null;
      }
      return w * from.r + from.c;
    }

    @Override
    public GridPoint decode(Integer from) {
      if (from == null) {
        return null;
      }
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
  }

  private static class VerticalHorizontalNeighborGridPointGraph extends GridPointGraph {

    private final BiPredicate<Integer, Integer> predicate;
    protected List<int[]> moves = Arrays.asList(
        new int[]{-1, 0},
        new int[]{1, 0},
        new int[]{0, -1},
        new int[]{0, 1}
    );

    public VerticalHorizontalNeighborGridPointGraph(int h, int w,
        BiPredicate<Integer, Integer> predicate) {
      super(h, w);
      this.predicate = predicate;
    }

    protected boolean predicate(int r, int c) {
      if (r < 0 || h <= r) {
        return false;
      }
      if (c < 0 || w <= c) {
        return false;
      }
      return predicate.test(r, c);
    }

    protected List<Edge<GridPoint>> neighbors(GridPoint from) {

      List<Edge<GridPoint>> ans = new ArrayList<>();

      for (int i = 0; i < 4; i++) {
        int[] move = moves.get(i);
        if (predicate(from.r + move[0], from.c + move[1])) {
          ans.add(new Edge<>(from, new GridPoint(from.r + move[0], from.c + move[1]), 1));
        }
      }

      return ans;
    }

    @Override
    public int getSize() {
      return h * w;
    }

    @Override
    public Collection<Edge<GridPoint>> getEdges(GridPoint from) {
      return neighbors(from);
    }
  }

  private static class AdjacencyMatrixGridPointGraph extends IntVertexGraph {

    private List<Integer> vertexes;

    private final int n;
    private final int[][] matrix;

    public AdjacencyMatrixGridPointGraph(int n, int[][] matrix) {
      this.n = n;
      this.matrix = matrix;
    }

    @Override
    public Collection<Integer> getVertexes() {
      // lazy load
      if (vertexes == null) {
        vertexes = IntStream.range(0, n).boxed().collect(Collectors.toList());
      }
      return vertexes;
    }

    @Override
    public int getSize() {
      return n;
    }

    @Override
    public List<Edge<Integer>> getEdges(Integer from) {
      return IntStream.range(0, n).mapToObj(to -> new Edge<>(from, to, matrix[from][to]))
          .collect(Collectors.toList());
    }
  }

  private static class AdjacencyListGridPointGraph extends IntVertexGraph {

    private List<Integer> vertexes;

    private final int n;
    private final List<List<Edge<Integer>>> edges;

    public AdjacencyListGridPointGraph(int n, List<List<Edge<Integer>>> edges) {
      this.n = n;
      this.edges = edges;
    }

    @Override
    public Collection<Integer> getVertexes() {
      // lazy load
      if (vertexes == null) {
        vertexes = IntStream.range(0, n).boxed().collect(Collectors.toList());
      }
      return vertexes;
    }

    @Override
    public int getSize() {
      return n;
    }

    @Override
    public List<Edge<Integer>> getEdges(Integer from) {
      return edges.get(from);
    }
  }


  private static abstract class GridPointGraph extends EncodedGraph<GridPoint> {

    public GridPointGraph(int h, int w) {
      super(new GridPointEncoder(h, w));
      this.h = h;
      this.w = w;
    }

    protected final int h;
    protected final int w;

    protected List<GridPoint> vertexes;

    @Override
    public Collection<GridPoint> getVertexes() {

      // lazy load
      if (vertexes == null) {
        vertexes = new ArrayList<>(w * h);
        for (int r = 0; r < h; r++) {
          for (int c = 0; c < w; c++) {
            vertexes.add(new GridPoint(r, c));
          }
        }
      }

      return vertexes;
    }
  }

  private static interface Encoded<E extends Encoded> {

  }

  private static interface Encoder<E extends Encoded> {

    int num();

    Integer encode(E from);

    E decode(Integer from);
  }

  private static abstract class EncodedGraph<V extends Encoded<V>> implements Graph<V> {

    public EncodedGraph(Encoder<V> encoder) {
      this.encoder = encoder;
      this.delegate = new IntVertexGraph() {
        @Override
        public Collection<Integer> getVertexes() {
          return EncodedGraph.this.getVertexes().stream()
              .map(encoder::encode)
              .collect(Collectors.toList());
        }

        @Override
        public int getSize() {
          return EncodedGraph.this.getSize();
        }

        @Override
        public Collection<Edge<Integer>> getEdges(Integer from) {
          Collection<Edge<V>> edges = EncodedGraph.this.getEdges(encoder.decode(from));
          List<Edge<Integer>> ans = new ArrayList<>(edges.size());
          for (Edge<V> e : edges) {
            ans.add(new Edge<>(
                encoder.encode(e.getFrom()), encoder.encode(e.getTo()), e.getWeight()));
          }
          return ans;
        }
      };
    }

    final Encoder<V> encoder;
    final IntVertexGraph delegate;

    public PathQuery<V> pathQuery(Function<Graph<Integer>, PathQuery<Integer>> delegate) {
      return new EncodedPathQuery<>(delegate, this);
    }

    public MultiPathQuery<V> multiPathQuery(
        Function<Graph<Integer>, MultiPathQuery<Integer>> delegate) {
      return new EncodedMultiPathQuery<>(delegate, this);
    }

    private static class EncodedPathQuery<V extends Encoded<V>> implements PathQuery<V> {

      EncodedGraph<V> graph;
      PathQuery<Integer> delegate;

      private EncodedPathQuery(Function<Graph<Integer>, PathQuery<Integer>> delegate,
          EncodedGraph<V> graph) {
        this.graph = graph;
        this.delegate = delegate.apply(graph.delegate);
      }

      @Override
      public VertexPath<V> path(V begin, V end) {
        VertexPath<Integer> path = delegate
            .path(graph.encoder.encode(begin), graph.encoder.encode(end));
        if (path == null) {
          return null;
        }
        return new EfficientVertexPath<>(graph.encoder.decode(path.getBegin()),
            graph.encoder.decode(path.getEnd()), path.getWeight());
      }
    }

    private static class EncodedMultiPathQuery<V extends Encoded<V>> implements MultiPathQuery<V> {

      EncodedGraph<V> graph;
      MultiPathQuery<Integer> delegate;

      private EncodedMultiPathQuery(Function<Graph<Integer>, MultiPathQuery<Integer>> delegate,
          EncodedGraph<V> graph) {
        this.graph = graph;
        this.delegate = delegate.apply(graph.delegate);
      }

      @Override
      public VertexPath<V> path(List<V> begin, V end) {
        List<Integer> list = begin.stream().map(graph.encoder::encode)
            .collect(Collectors.toList());
        VertexPath<Integer> path = delegate
            .path(list, graph.encoder.encode(end));
        if (path == null) {
          return null;
        }
        return new EfficientVertexPath<>(graph.encoder.decode(path.getBegin()),
            graph.encoder.decode(path.getEnd()), path.getWeight());
      }
    }

  }

  private static interface PathQuery<V> {

    VertexPath<V> path(V begin, V end);
  }

  private static interface MultiPathQuery<V> {

    VertexPath<V> path(List<V> begin, V end);
  }

  private static abstract class QueuedPathQuery<V> implements PathQuery<V> {

    protected final Graph<V> graph;
    protected final Queue<VertexPath<V>> queue;

    public QueuedPathQuery(Graph<V> graph, Queue<VertexPath<V>> queue) {
      this.graph = graph;
      this.queue = queue;
    }

    public VertexPath<V> path(V begin, V end) {

      prepare(begin, end);
      queue.add(new EfficientVertexPath<>(begin));
      return search(end);
    }

    protected VertexPath<V> search(V end) {
      while (!queue.isEmpty()) {
        VertexPath<V> path = queue.remove();
        V head = path.getEnd();

        if (head.equals(end)) {
          return path;
        }

        for (Edge<V> e : graph.getEdges(head)) {
          if (!predicate(e)) {
            continue;
          }
          mark(path, e);
          queue.add(path.append(e));
        }
      }
      return null;
    }

    abstract void prepare(V begin, V end);

    abstract boolean predicate(Edge<V> edge);

    abstract void mark(VertexPath<V> path, Edge<V> edge);
  }

  private static class DijkstraPathQuery extends QueuedPathQuery<Integer> {

    private final long[] distance;

    public DijkstraPathQuery(Graph<Integer> graph) {
      super(graph, new PriorityQueue<>(
          Comparator.comparingLong(VertexPath::getWeight)));
      distance = new long[graph.getSize()];
    }


    @Override
    void prepare(Integer begin, Integer end) {
      for (Integer v : graph.getVertexes()) {
        distance[v] = Integer.MAX_VALUE;
      }
    }

    @Override
    boolean predicate(Edge<Integer> edge) {
      return distance[edge.getFrom()] + edge.getWeight() < distance[edge.getTo()];
    }

    @Override
    void mark(VertexPath<Integer> path, Edge<Integer> edge) {
      distance[edge.getTo()] = path.getWeight() + edge.getWeight();
    }
  }

  private static class BfsPathQuery extends QueuedPathQuery<Integer> implements
      MultiPathQuery<Integer> {

    final boolean[] visited;

    public BfsPathQuery(Graph<Integer> graph) {
      super(graph, new ArrayDeque<>());
      visited = new boolean[graph.getSize()];
    }

    @Override
    void prepare(Integer begin, Integer end) {
      visited[begin] = true;
    }

    @Override
    boolean predicate(Edge<Integer> edge) {
      return !visited[edge.getTo()];
    }

    @Override
    void mark(VertexPath<Integer> path, Edge<Integer> edge) {
      visited[edge.getTo()] = true;
    }

    public VertexPath<Integer> path(List<Integer> begins, Integer end) {

      for (int begin : begins) {
        prepare(begin, end);
        queue.add(new EfficientVertexPath<>(begin));
      }
      return search(end);
    }

  }

  private static abstract class MemoDfsPathQuery<V> extends DfsPathQuery<V> {

    public MemoDfsPathQuery(Graph<V> graph) {
      super(graph);
    }

    abstract VertexPath<V> memo(VertexPath<V> path, V parent,
        V end);

    @Override
    public VertexPath<V> path(VertexPath<V> path, V parent,
        V end) {
      VertexPath<V> memo = memo(path, parent, end);
      if (memo != null) {
        return memo;
      }
      return super.path(path, parent, end);
    }
  }

  private static class DfsPathQuery<V> implements PathQuery<V> {

    protected final Graph<V> graph;

    public DfsPathQuery(Graph<V> graph) {
      this.graph = graph;
    }

    @Override
    public VertexPath<V> path(V begin, V end) {
      return path(new EfficientVertexPath<>(begin), null, end);
    }

    protected VertexPath<V> path(VertexPath<V> path, V parent,
        V end) {
      V head = path.getEnd();
      if (path.getEnd().equals(end)) {
        return path;
      }
      for (Edge<V> e : graph.getEdges(head)) {
        if (!e.getTo().equals(parent)) {
          VertexPath<V> next = path(path.append(e), head, end);
          if (next != null) {
            return next;
          }
        }
      }
      return null;
    }
  }

  private static class WarshallFloydQuery implements PathQuery<Integer> {

    private VertexPath<Integer>[][] shortest;

    private WarshallFloydQuery(Graph<Integer> graph) {
      Collection<Integer> nodes = graph.getVertexes();

      shortest = new VertexPath[nodes.size()][nodes.size()];

      for (int from : nodes) {
        Collection<Edge<Integer>> edges = graph.getEdges(from);
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
              if (shortest[from][dest] == null
                  || pathA.getWeight() + pathB.getWeight() < shortest[from][dest]
                  .getWeight()) {
                shortest[from][dest] = pathA.append(pathB);
              }
            }
          }
        }
      }
    }

    @Override
    public VertexPath<Integer> path(Integer begin, Integer end) {
      return shortest[begin][end];
    }
  }

  private static abstract class IntVertexGraph implements Graph<Integer> {

  }

  static class Edge<V> {

    public Edge(V from, V to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    private final V from;

    private final V to;
    private final int weight;


    V getFrom() {
      return from;
    }

    V getTo() {
      return to;
    }

    int getWeight() {
      return weight;
    }
  }

  static interface VertexPath<V> {

    V getBegin();

    V getEnd();

    int getWeight();

    VertexPath<V> append(VertexPath<V> other);

    void merge(VertexPath<V> other);

    VertexPath<V> append(Edge<V> edge);

    void merge(Edge<V> edge);
  }

  static class EfficientVertexPath<V> implements VertexPath<V> {

    private V begin;
    private V end;
    private int weight;

    public EfficientVertexPath(V begin) {
      this.begin = begin;
      this.end = begin;
      this.weight = 0;
    }

    public EfficientVertexPath(V begin, V end, int weight) {
      this.begin = begin;
      this.end = end;
      this.weight = weight;
    }

    public EfficientVertexPath(Edge<V> edge) {
      this.begin = edge.getFrom();
      this.end = edge.getTo();
      this.weight = edge.getWeight();
    }

    private EfficientVertexPath(VertexPath<V> path, Edge<V> append) {
      this.begin = path.getBegin();
      if (!path.getEnd().equals(append.getFrom())) {
        throw new IllegalStateException("not correct edge.");
      }
      this.end = append.getTo();
      this.weight = path.getWeight() + append.getWeight();
    }

    private EfficientVertexPath(VertexPath<V> pathA, VertexPath<V> pathB) {
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
    public int getWeight() {
      return weight;
    }

    @Override
    public VertexPath<V> append(VertexPath<V> other) {
      return new EfficientVertexPath<>(this, other);
    }

    @Override
    public void merge(VertexPath<V> other) {
      this.end = other.getEnd();
      this.weight += other.getWeight();
    }

    @Override
    public VertexPath<V> append(Edge<V> edge) {
      return new EfficientVertexPath<>(this, edge);
    }

    @Override
    public void merge(Edge<V> edge) {
      this.end = edge.getTo();
      this.weight += edge.getWeight();
    }
  }

  private static interface Graph<V> {

    int getSize();

    Collection<V> getVertexes();

    Collection<Edge<V>> getEdges(V from);
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
