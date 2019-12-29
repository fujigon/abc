package diverta2019.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

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

    int m = sc.nextInt();

    List<Set<Integer>> list = new ArrayList<>();

    for (int i = 0; i < m; i++) {

      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();

      boolean done = false;
      for (Set<Integer> set : list) {
        if (set.contains(x) || set.contains(y)) {
          set.add(x);
          set.add(y);
          done = true;
          break;
        }
      }
      if (!done) {
        Set<Integer> set = new HashSet<>();
        set.add(x);
        set.add(y);
        list.add(set);
      }
    }
    for (int i = 1; i <= n; i++) {
      boolean done = false;
      for (Set<Integer> set : list) {
        if (set.contains(i)) {
          set.add(i);
          done = true;
          break;
        }
      }
      if (!done) {
        Set<Integer> set = new HashSet<>();
        set.add(i);
        list.add(set);
      }

    }
    os.println(list.size());
  }
}