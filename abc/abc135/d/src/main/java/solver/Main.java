package solver;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final Long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    String s = sc.next();
    int n = s.length();
    long[][] dp = new long[n][13];

    if (s.charAt(0) == '?') {
      for (int d = 0; d <= 9; d++) {
        dp[0][d] = 1;
      }
    } else {
      int d = s.charAt(0) - '0';
      dp[0][d] = 1;
    }

    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == '?') {
        for (int d = 0; d <= 9; d++) {
          for (int j = 0; j < 13; j++) {
            int mod = (j * 10 + d) % 13;
            dp[i][mod] = (dp[i][mod] + dp[i - 1][j]) % MOD;
          }
        }
      } else {
        int d = s.charAt(i) - '0';
        for (int j = 0; j < 13; j++) {
          int mod = (j * 10 + d) % 13;
          dp[i][mod] = (dp[i][mod] + dp[i - 1][j]) % MOD;
        }
      }
    }
    os.println(dp[n - 1][5]);
  }
}