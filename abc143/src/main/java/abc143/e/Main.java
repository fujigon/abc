package abc143.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

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
    Map<Integer, Set<Edge>> map = new HashMap<>();

    // exclude the expensive edge (than L) in advance
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      if (c <= l) {
        Edge edge1 = new Edge();
        edge1.fr = a;
        edge1.to = b;
        edge1.cost = c;
        Set<Edge> edges1 = map.getOrDefault(edge1.fr, new HashSet<>());
        edges1.add(edge1);
        map.put(edge1.fr, edges1);

        Edge edge2 = new Edge();
        edge2.fr = b;
        edge2.to = a;
        edge2.cost = c;
        Set<Edge> edges2 = map.getOrDefault(edge2.fr, new HashSet<>());
        edges2.add(edge2);
        map.put(edge2.fr, edges2);
      }
    }

    int q = sc.nextInt();
    List<Pair> pairs = new ArrayList<>(q);
    Move[][] dijkstras = new Move[n + 1][];
    for (int i = 0; i < q; i++) {
      int s = sc.nextInt();
      int t = sc.nextInt();
      Pair p = new Pair();
      p.s = s;
      p.t = t;
      pairs.add(p);
      if (dijkstras[s] == null) {
        dijkstras[s] = dijkstra(s, map, n, l);
      }
    }

    for (Pair p : pairs) {
      if (dijkstras[p.s][p.t] == null) {
        os.println(-1);
      } else {
        os.println(dijkstras[p.s][p.t].refill);
      }
    }
  }

  private static class Pair {
    int s;
    int t;
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

  private static Move[] dijkstra(int s, Map<Integer, Set<Edge>> map, int n, int l) {
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
      for (Edge edge : map.getOrDefault(fr, new HashSet<>())) {
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
}