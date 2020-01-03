package solver;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Pair {

    int x;
    int y;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pair pair = (Pair) o;
      return x == pair.x &&
          y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  private static class Vert {
    int x;
    int y;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Vert pair = (Vert) o;
      return x == pair.x &&
          y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    if (n == 1) {
      os.println(1);
      return;
    }

    List<Pair> pairs = new ArrayList<>(n);

    int[] x = new int[n];
    int[] y = new int[n];

    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      Pair pair = new Pair();
      pair.x = x[i];
      pair.y = y[i];
      pairs.add(pair);
    }

    Map<Vert, Integer> occurs = new HashMap<>();
    for (int i = 0 ; i < n; i++) {
      for (int j = 0; j < n; j++){
        if (i == j) continue;
        Vert v = new Vert();
        Pair p1 = pairs.get(i);
        Pair p2 = pairs.get(j);
        v.x = p1.x - p2.x;
        v.y = p1.y - p2.y;
        int occur = occurs.getOrDefault(v, 0);
        occur++;
        occurs.put(v, occur);
      }
    }

    Vert maxOccurVert = null;
    int maxOccur = Integer.MIN_VALUE;
    for (Vert v : occurs.keySet()) {
      if (occurs.get(v) > maxOccur) {
        maxOccurVert = v;
        maxOccur = occurs.get(v);
      }
    }

    os.println(n - 1 - maxOccur + 1);
  }
}