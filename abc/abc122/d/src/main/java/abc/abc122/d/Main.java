package abc.abc122.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

// TODO review
public class Main {

  private static final int MOD = 100000007;

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    long[][] dp = new long[n + 1][4];
    // A = 0, C = 1, G = 2, T = 3

    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[0][2] = 0;
    dp[0][3] = 0;

    // A, C, G, T
    dp[1][0] = 1;
    dp[1][1] = 1;
    dp[1][2] = 1;
    dp[1][3] = 1;

    // ?A, ?C, ?G, ?T
    dp[2][0] = 4;
    dp[2][1] = 4;
    dp[2][2] = 4;
    dp[2][3] = 4;

    // ??A, ??C, ??G, ??T
    // AGC, ACG, GAC is invalid
    dp[3][0] = 16;
    dp[3][1] = 15;
    dp[3][2] = 14;
    dp[3][3] = 16;

    for (int i = 4; i <= n; i++) {
      // ???A = **A+A + **C+A + **G+A + **T+A
      dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD;

      // ???C = **A+C + **C+C + *G+C + **T+C - A+?+G+C - A+G+?+C (AGGC is duplicated with A+?+G+C and AG+?+C) (AGAC is duplicated with ??A+C and AG+?+C)
      dp[i][1] = ((dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD) - ((4 * dp[i - 3][0] - 1 + 4 * dp[i - 3][0] - 1) % MOD) % MOD;

      // ???G = **A+G + **C+G + **G+G + **T+G - *ACG
      dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] - dp[i - 2][1]) % MOD;

      // ???T = **A+T + **C+T + **G+T + **T+T
      dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD;
    }

    int answer = 0;
    for (int i = 0; i < 4; i++) {
      answer += dp[n][i] % MOD;
    }
    os.println(answer);
  }

  static void solve_(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    long[][] dp = new long[n][16];
    // AA = 0, AC = 1, AG = 2, AT = 3
    // CA = 4, CC = 5, CG = 6, CT = 7
    // GA = 8, GC = 9, GG = 10, GT = 11
    // TA = 12, TC = 13, TG = 14, TT = 15
    // dp[i][j] is number of i length, ending with j's chars ending`, and valid .

    // AGC, ACG, GAC is invalid

    for (int i = 0; i < 16; i ++){
      dp[1][i] = 1;
    }

    for (int i = 0; i < n - 1; i++) {
      // all ending pattern
      for (int j = 0; j < 16; j++) {

        // mod
        dp[i][j] = dp[i][j] % MOD;

        int lastChar = j % 4;
        // A - ending
        if (lastChar == 0) {
          // ?AA
          dp[i + 1][0] +=  dp[i][j];
          // ?AC
          if (j != 8) { // exclude GAC
            dp[i + 1][1] += dp[i][j];
          }
          // ?AG
          dp[i + 1][2] += dp[i][j];
          // ?GT
          dp[i + 1][3] += dp[i][j];

          // C - ending
        } else if (lastChar == 1) {
          // ?CA
          dp[i + 1][4] += dp[i][j];
          // ?CC
          dp[i + 1][5] += dp[i][j];
          // ?CG
          if (j != 1) { // exclude ACG
            dp[i + 1][6] += dp[i][j];
          }
          // ?CT
          dp[i + 1][7] += dp[i][j];

          // G - ending
        } else if (lastChar == 2){
          // ?GA
          dp[i + 1][8] += dp[i][j];
          // ?GC
          if (j != 2) {
            dp[i + 1][9] += dp[i][j];
          }
          // ?GG
          dp[i + 1][10] += dp[i][j];
          // ?GT
          dp[i + 1][11] += dp[i][j];

          // T - ending
        } else {
          // ? TA
          dp[i + 1][12] += dp[i][j];
          // ? TC
          dp[i + 1][13] += dp[i][j];
          // ? TG
          dp[i + 1][14] += dp[i][j];
          // ? TT
          dp[i + 1][15] += dp[i][j];
        }
      }
    }

    int answer = 0;
    for (int i = 0; i < 16; i++) {
      answer += dp[n - 1][i] % MOD;
    }
    os.println(answer);
  }

}