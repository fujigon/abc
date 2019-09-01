package abc139.f;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Point {
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
      Point point = (Point) o;
      return x == point.x &&
          y == point.y;
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
    int[] x = new int[n];
    int[] y = new int[n];

    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    Set<Point> reachables = new HashSet<>();
    Point o = new Point();
    reachables.add(o);

    double max = 0.0d;
    for (int i = 0; i < n; i++) {
      Set<Point> nexts = new HashSet<>();
      nexts.addAll(reachables);
      for (Point p : reachables) {
        
      }
    }
  }
}