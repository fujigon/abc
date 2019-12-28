package pakencamp2019day3.d;

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

    int[] red = new int[n]; // color 0 
    int[] blu = new int[n]; // color 1
    int[] wht = new int[n]; // color 2
    int[] blc = new int[n];
    
    for (int j = 0; j < 5; j++) {
      String line = sc.next();
      for (int i = 0; i < n; i++) {
        switch (line.charAt(i)) {
          case 'R':
            red[i]++;
            break;
          case 'B':
            blu[i]++;
            break;
          case 'W':
            wht[i]++;
            break;
          case '#':
            blc[i]++;
            break;
        }
      }
    }
    
    int[][] dp = new int[n][3];
    
    dp[0][0] = 5 - red[0];
    dp[0][1] = 5 - blu[0];
    dp[0][2] = 5 - wht[0];
    
    for (int i = 1; i < n; i++) {
      // red
      dp[i][0] = 
          Math.min(
              dp[i - 1][1] + 5 - red[i],  // last filled is blue and its smallest color changes
              dp[i - 1][2] + 5 - red[i]   // last filled is white and its smallest color changes
          );
      // blue
      dp[i][1] = 
          Math.min(
              dp[i - 1][0] + 5 - blu[i],  // last filled is red and its smallest color changes
              dp[i - 1][2] + 5 - blu[i]   // last filled is white and its smallest color changes
          );
      // white
      dp[i][2] =
          Math.min(
              dp[i - 1][0] + 5 - wht[i],  // last filled is red and its smallest color changes
              dp[i - 1][1] + 5 - wht[i]   // last filled is blue and its smallest color changes
          );
    }

    os.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
  }
}