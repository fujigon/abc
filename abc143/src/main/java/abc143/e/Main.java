package abc143.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
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

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] costs = new int[1 << n];
    Arrays.fill(costs, -1);

    for (int i = 0; i < m; i++) {
      int cost = sc.nextInt();
      int opening = 0;
      int num = sc.nextInt();
      for (int j = 0; j < num; j++) {
        opening += 1 << (sc.nextInt() - 1);
      }
      if (costs[opening] < 0 || cost < costs[opening]) {
        costs[opening] = cost;
      }
    }

    for (int i = 0; i < 1 << n; i++) {
      for (int j = 0; j < 1 << n; j++) {
        if (costs[i] < 0 || costs[j] < 0) {
          continue;
        }
        int pattern = 0;
        for (int bit = 0; bit < n; bit++) {
          pattern += (((i >> bit) & 1) | ((j >> bit) & 1)) << bit;
        }
        if (costs[pattern] < 0) costs[pattern] = costs[i] + costs[j];
        else {
          costs[pattern] = Math.min(costs[pattern], costs[i] + costs[j]);
        }
      }
    }

    os.println(costs[(1 << n) - 1]);
  }
}