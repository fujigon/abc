package com.solver.atcoder.abc.abc133.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int k = sc.nextInt();

    List<Set<Graph.Edge<Integer>>> list = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      list.add(new HashSet<>());
    }

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      list.get(a).add(new Graph.Edge<>(a, b, 1));
      list.get(b).add(new Graph.Edge<>(b, a, 1));
    }

    Graph<Integer> graph = new AdjacencyListGridPointGraph(n, list);

    ColoringMemoDfsPathQuery query =  new ColoringMemoDfsPathQuery(graph, n, k);
        query.path(0, null);

    os.println(query.ans);
  }

  private static class ColoringMemoDfsPathQuery extends MemoDfsPathQuery {

    long ans = 1L;
    private final int n;
    private final int k;
    private int[] childColored;

    public ColoringMemoDfsPathQuery(Graph<Integer> graph, int n, int k) {
      super(graph);
      this.n = n;
      this.k = k;
      this.childColored = new int[n];
    }

    @Override
    Graph.VertexPath<Integer> memo(Graph.VertexPath<Integer> path, Integer parent, Integer end) {
      long pattern = k;
      if (parent != null) {
        pattern -= 1; // parent itself
        pattern -= childColored[parent]; // siblings
        if (parent != 0) { // if not root
          pattern -= 1; // grand parent
        }
        childColored[parent]++;
      }
      ans *= pattern;
      ans %= MOD;
      return null;
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

  private static class AdjacencyMatrixGridPointGraph extends IntVertexGraph {

    private final Set<Integer> vertexes = new HashSet<>();

    private final int n;
    private final int[][] matrix;

    public AdjacencyMatrixGridPointGraph(int n, int[][] matrix) {
      this.n = n;
      this.matrix = matrix;
      IntStream.range(0, n).forEach(vertexes::add);
    }

    @Override
    public Set<Integer> getVertexes() {
      return vertexes;
    }

    @Override
    public Set<Edge<Integer>> getEdges(Integer from) {
      return IntStream.range(0, n).mapToObj(to -> new Edge<>(from, to, matrix[from][to]))
          .collect(Collectors.toSet());
    }
  }

  private static class AdjacencyListGridPointGraph extends IntVertexGraph {

    private final Set<Integer> vertexes = new HashSet<>();

    private final int n;
    private final List<Set<Edge<Integer>>> edges;

    public AdjacencyListGridPointGraph(int n, List<Set<Edge<Integer>>> edges) {
      this.n = n;
      this.edges = edges;
      IntStream.range(0, n).forEach(vertexes::add);
    }

    @Override
    public Set<Integer> getVertexes() {
      return vertexes;
    }

    @Override
    public Set<Edge<Integer>> getEdges(Integer from) {
      return edges.get(from);
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

    public PathQuery<V> pathQuery(Function<Graph<Integer>, PathQuery<Integer>> delegate) {
      return new EncodedPathQuery<>(delegate, this);
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
  }

  private static interface PathQuery<V> {

    Graph.VertexPath<V> path(V begin, V end);
  }

  private static abstract class QueuedPathQuery implements PathQuery<Integer> {

    protected final Graph<Integer> graph;
    private final Queue<Graph.VertexPath<Integer>> queue;

    public QueuedPathQuery(Graph<Integer> graph, Queue<Graph.VertexPath<Integer>> queue) {
      this.graph = graph;
      this.queue = queue;
    }

    public Graph.VertexPath<Integer> path(Integer begin, Integer end) {

      prepare(begin, end);

      queue.add(new Graph.EfficientVertexPath<>(begin));

      while (!queue.isEmpty()) {
        Graph.VertexPath<Integer> path = queue.remove();
        Integer head = path.getEnd();

        if (head.equals(end)) {
          return path;
        }
        for (Graph.Edge<Integer> e : graph.getEdges(head)) {
          if (predicate(e)) {
            Graph.VertexPath<Integer> p = path.append(e);
            queue.add(p);
            mark(path, e, p);
          }
        }
      }
      return null;
    }

    abstract void prepare(Integer begin, Integer end);

    abstract boolean predicate(Graph.Edge<Integer> edge);

    abstract void mark(Graph.VertexPath<Integer> existing, Graph.Edge<Integer> edge,
        Graph.VertexPath<Integer> path);
  }

  private static class DijkstraPathQuery extends QueuedPathQuery {

    private final long[] distance;

    public DijkstraPathQuery(Graph<Integer> graph) {
      super(graph, new PriorityQueue<>(
          Comparator.comparingLong(Graph.VertexPath::getWeight)));
      distance = new long[graph.getVertexes().size()];
    }


    @Override
    void prepare(Integer begin, Integer end) {
      IntStream.range(0, graph.getVertexes().size())
          .forEach(i -> distance[i] = Integer.MAX_VALUE);
      distance[begin] = 0;
    }

    @Override
    boolean predicate(Graph.Edge<Integer> edge) {
      return distance[edge.getFrom()] + edge.getWeight() < distance[edge.getTo()];
    }

    @Override
    void mark(Graph.VertexPath<Integer> existing, Graph.Edge<Integer> edge,
        Graph.VertexPath<Integer> path) {
      distance[path.getEnd()] = path.getWeight();
    }
  }

  private static class BfsPathQuery extends QueuedPathQuery {

    private final Set<Integer> visited = new HashSet<>();

    public BfsPathQuery(Graph<Integer> graph) {
      super(graph, new ArrayDeque<>());
    }

    @Override
    void prepare(Integer begin, Integer end) {
      visited.add(begin);
    }

    @Override
    boolean predicate(Graph.Edge<Integer> edge) {
      return !visited.contains(edge.getTo());
    }

    @Override
    void mark(Graph.VertexPath<Integer> existing, Graph.Edge<Integer> edge,
        Graph.VertexPath<Integer> path) {
      visited.add(path.getEnd());
    }
  }

  private static abstract class MemoDfsPathQuery extends DfsPathQuery {

    public MemoDfsPathQuery(Graph<Integer> graph) {
      super(graph);
    }

    abstract Graph.VertexPath<Integer> memo(Graph.VertexPath<Integer> path, Integer parent,
        Integer end);

    @Override
    public Graph.VertexPath<Integer> path(Graph.VertexPath<Integer> path, Integer parent,
        Integer end) {
      Graph.VertexPath<Integer> memo = memo(path, parent, end);
      if (memo != null) {
        return memo;
      }
      return super.path(path, parent, end);
    }
  }

  private static class DfsPathQuery implements PathQuery<Integer> {

    protected final Graph<Integer> graph;

    public DfsPathQuery(Graph<Integer> graph) {
      this.graph = graph;
    }

    @Override
    public Graph.VertexPath<Integer> path(Integer begin, Integer end) {
      return path(new Graph.EfficientVertexPath<>(begin), null, end);
    }

    protected Graph.VertexPath<Integer> path(Graph.VertexPath<Integer> path, Integer parent,
        Integer end) {
      Integer head = path.getEnd();
      if (path.getEnd().equals(end)) {
        return path;
      }
      for (Graph.Edge<Integer> e : graph.getEdges(head)) {
        if (!e.getTo().equals(parent)) {
          Graph.VertexPath<Integer> next = path(path.append(e), head, end);
          if (next != null) {
            return next;
          }
        }
      }
      return null;
    }
  }

  private static class WarshallFloydQuery implements PathQuery<Integer> {

    private Graph.VertexPath<Integer>[][] shortest;

    private WarshallFloydQuery(Graph<Integer> graph) {
      Set<Integer> nodes = graph.getVertexes();

      shortest = new Graph.VertexPath[nodes.size()][nodes.size()];

      for (int from : nodes) {
        Set<Graph.Edge<Integer>> edges = graph.getEdges(from);
        for (Graph.Edge<Integer> e : edges) {
          shortest[e.getFrom()][e.getTo()] = new Graph.EfficientVertexPath<>(e);
        }
        shortest[from][from] = new Graph.EfficientVertexPath<>(from);
      }

      for (int relay : nodes) {
        for (int from : nodes) {
          for (int dest : nodes) {
            Graph.VertexPath<Integer> pathA = shortest[from][relay];
            Graph.VertexPath<Integer> pathB = shortest[relay][dest];
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
    public Graph.VertexPath<Integer> path(Integer begin, Integer end) {
      return shortest[begin][end];
    }
  }

  private static abstract class IntVertexGraph implements Graph<Integer> {

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

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight &&
            Objects.equals(from, edge.from) &&
            Objects.equals(to, edge.to);
      }

      @Override
      public int hashCode() {
        return Objects.hash(from, to, weight);
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

      VertexPath<V> append(Edge<V> edge);
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
      public long getWeight() {
        return weight;
      }

      @Override
      public VertexPath<V> append(VertexPath<V> other) {
        return new EfficientVertexPath<>(this, other);
      }

      @Override
      public VertexPath<V> append(Edge<V> edge) {
        return new EfficientVertexPath<>(this, edge);
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

}