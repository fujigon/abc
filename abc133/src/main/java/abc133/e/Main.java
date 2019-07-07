package abc133.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static long MOD = 1000000007;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    Map<Integer, Set<Integer>> xoccurs = new HashMap<>();
    Map<Integer, Set<Integer>> yoccurs = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      Set<Integer> ySetOfX = xoccurs.getOrDefault(x, new HashSet<>());
      ySetOfX.add(y);
      xoccurs.put(x, ySetOfX);

      Set<Integer> xSetOfY = yoccurs.getOrDefault(y, new HashSet<>());
      xSetOfY.add(x);
      yoccurs.put(y, xSetOfY);
    }

    Set<Integer> xMultiples = new HashSet<>();
    Set<Integer> yMultiples = new HashSet<>();

    for (int x : xoccurs.keySet()) {
      if (xoccurs.get(x).size() == 1) continue;
      Set<Integer> ys = xoccurs.get(x);
      yMultiples.addAll(ys);
      for (int y : ys) {
        Set<Integer> xs = yoccurs.get(y);
        if (xs != null) {
          xMultiples.addAll(xs);
        }
      }
    }

    for (int y : yoccurs.keySet()) {
      if (yoccurs.get(y).size() == 1) continue;
      Set<Integer> xs = yoccurs.get(y);
      xMultiples.addAll(xs);
      for (int x : xs) {
        Set<Integer> ys = xoccurs.get(x);
        if (ys != null) {
          yMultiples.addAll(ys);
        }
      }
    }

    int count = 0;
    for (int x : xMultiples) {
      for (int y : yMultiples) {
        if (!xoccurs.containsKey(x) || !xoccurs.get(x).contains(y)) count++;
      }
    }

    os.println(count);
  }

}
