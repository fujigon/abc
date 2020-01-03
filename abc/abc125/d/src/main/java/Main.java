import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    long[] a = new long[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    long[][] dp = new long[n + 1][2];
    // dp(i, 0) : A0...Ai, wo Ai+1 flipping,
    // dp(i, 1) : A1...Ai, wi Ai+1 flipping.

    dp[0][0] = 0;
    dp[0][1] = -1000000001L;

    for (int i = 0; i < n; i++) {
      // dp[i][0] + a[i] (Ai+1 wo flipping).
      // dp[i][1] - a[i] (Ai+1 wi flipping).
      dp[i + 1][0] = Math.max(dp[i][0] + a[i], dp[i][1] - a[i]);

      // dp[i][0] - a[i] (Ai+1 wi flipping).
      // dp[i][1] + a[i] (Ai+1 wo flipping).
      dp[i + 1][1] = Math.max(dp[i][0] - a[i], dp[i][1] + a[i]);
    }
    os.println(dp[n][0]);
  }
}