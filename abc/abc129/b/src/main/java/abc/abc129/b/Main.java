package abc.abc129.b;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    int[] w = new int[n];

    for (int i = 0; i < n; i++) {
      w[i] = sc.nextInt();
    }

    int min = Integer.MAX_VALUE;
    for (int t = 0; t < n - 1; t++) {
      int s1 = 0;
      int s2 = 0;
      for (int l = 0; l <= t; l++) {
        s1 += w[l];
      }
      for (int r = t + 1; r < n; r++) {
        s2 += w[r];
      }
      min = Math.min(min, Math.abs(s2 - s1));
    }
    os.println(min);
  }
}