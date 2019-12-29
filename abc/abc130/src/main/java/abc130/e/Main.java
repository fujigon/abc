package abc131.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    int m = sc.nextInt();

    List<Integer> s = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      s.add(sc.nextInt());
    }
    for (int i = 0; i < m; i++) {
      t.add(sc.nextInt());
    }

    Map<Integer, Set<Integer>> sOccur = new HashMap<>();
    for (int i = 0; i < m; i++) {
      Set<Integer> occur = sOccur.getOrDefault(s.get(i), new HashSet<>());
      occur.add(i);
      sOccur.put(s.get(i), occur);
    }

    Map<Integer, Set<Integer>> tOccur = new HashMap<>();
    for (int i = 0; i < m; i++) {
      Set<Integer> occur = tOccur.getOrDefault(t.get(i), new HashSet<>());
      occur.add(i);
      tOccur.put(t.get(i), occur);
    }

    Map<Pair, Long> memo = new HashMap<>();

    os.println(search(sOccur, tOccur, 0, 0, memo));
  }

  private static class Pair {

    int sSize;
    int tSize;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pair pair = (Pair) o;
      return sSize == pair.sSize &&
          tSize == pair.tSize;
    }

    @Override
    public int hashCode() {
      return Objects.hash(sSize, tSize);
    }
  }

  private static long search(Map<Integer, Set<Integer>> s, Map<Integer, Set<Integer>> t, int sStart,
      int tStart, Map<Pair, Long> memo) {
    Pair p = new Pair();
    p.sSize = sStart;
    p.tSize = tStart;
    if (memo.containsKey(p)) {
      return memo.get(p);
    }

    long res = 0;
    // empty
    res++;
    res = res % MOD;
    for (Integer toSearch : s.keySet()) {
      if (!t.containsKey(toSearch)) {
        continue;
      }
      Set<Integer> sOccur = s.get(toSearch);
      Set<Integer> tOccur = t.get(toSearch);
      for (int i : sOccur) {
        if (i < sStart) {
          continue;
        }
        for (int j : tOccur) {
          if (j < tStart) {
            continue;
          }
          res += search(s, t, i + 1, j + 1, memo);
          res = res % MOD;
        }
      }
    }
    memo.put(p, res);
    return res;
  }
}
