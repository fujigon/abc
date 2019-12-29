package pakencamp2019day3.c;

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
    int m = sc.nextInt();
    
    long[][] scores = new long[n][m];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        scores[i][j] = sc.nextLong();
      }
    }
    
    long max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = i + 1; j < m; j++) {
        long total = 0;
        for (int k = 0; k < n; k++) {
          total += Math.max(scores[k][i], scores[k][j]); 
        }
        max = Math.max(max, total);
      }
    }

    os.println(max);
  }
}