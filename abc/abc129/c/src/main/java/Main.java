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
    int m = sc.nextInt();

    Set<Integer> broken = new HashSet<>(m);

    for (int i = 0; i < m; i++) {
      broken.add(sc.nextInt());
    }

    long[] route = new long[n + 1];

    route[0] = 1;

    for (int i = 0; i < n; i++) {
      if (i + 1 <= n) {
        if (!broken.contains(i + 1)) {
          route[i + 1] = (route[i + 1] + route[i]) % MOD;
        }
      }
      if (i + 2 <= n) {
        if (!broken.contains(i + 2)) {
          route[i + 2] = (route[i + 2] + route[i]) % MOD;
        }
      }
    }

    os.println(route[n]);
  }
}