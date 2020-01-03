package solver;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Pair {
    int u;
    int v;
    long w;
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    // u1 is always in white
    Set<Integer> white = new HashSet<>();

    Set<Integer> black = new HashSet<>();

    // u -> [(u, v, w), .. ]
    Map<Integer, List<Pair>> rslvs = new HashMap<>();

    for (int i = 0; i < n - 1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      long w = sc.nextLong();

      List<Pair> list1 = rslvs.getOrDefault(u, new ArrayList<>());
      Pair p1 = new Pair();
      p1.u = u;
      p1.v = v;
      p1.w = w;
      list1.add(p1);
      rslvs.put(u, list1);

      List<Pair> list2 = rslvs.getOrDefault(v, new ArrayList<>());
      Pair p2 = new Pair();
      p2.u = v;
      p2.v = u;
      p2.w = w;
      list2.add(p2);
      rslvs.put(v, list2);
    }

    Set<Integer> unresolved = new HashSet<>();

    for (int i = 1; i <= n; i++) {
      unresolved.add(i);
    }

    while (!unresolved.isEmpty()) {
      Integer enter = unresolved.iterator().next();
      unresolved.remove(enter);
    }

    // 1 is always white.
    white.add(1);

    Queue<Integer> resolved = new LinkedList<>();
    resolved.add(1);
    while(!resolved.isEmpty()) {
      Integer r = resolved.remove();

      List<Pair> list = rslvs.get(r);

      for (Pair p : list) {
        // already visited
        if (white.contains(p.v) || black.contains(p.v)) {
          continue;
        }
        // u is white
        if (white.contains(p.u)) {
          if (p.w % 2 == 0) {
            white.add(p.v);
          } else {
            black.add(p.v);
          }
        } else { // u is black
          if (p.w % 2 == 0) {
            black.add(p.v);
          } else {
            white.add(p.v);
          }
        }
        resolved.add(p.v);
      }
    }

    for (int i = 1; i <= n; i++) {
      if (white.contains(i)) {
        os.println('0');
      } else {
        os.println('1');
      }
    }
  }
}