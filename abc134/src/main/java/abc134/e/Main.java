package abc134.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

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

    Map<Integer, Set<Integer>> connected = new HashMap<>();

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      Set<Integer> conn;

      // a -> b
      conn = connected.getOrDefault(a, new HashSet<>());
      conn.add(b);
      connected.put(a, conn);

      // b -> a
      conn = connected.getOrDefault(b, new HashSet<>());
      conn.add(a);
      connected.put(b, conn);
    }
    Set<Integer> done = new HashSet<>();

    long value = dfs(1, 1, connected, done, k, k, 0);
    os.println(value);
  }

  private static long dfs(int node, long value, Map<Integer, Set<Integer>> connected, Set<Integer> done, long k, long color, int grandParent) {
    done.add(node);
    value = value * color % MOD;
    long colored = 0;

    if (!connected.containsKey(node)) return value;

    for (Integer next : connected.get(node)) {
      if (done.contains(next)) continue;
      colored++;
      value = dfs(next, value, connected, done,k, (k - colored - grandParent) , 1);
    }
    return value;
  }
}