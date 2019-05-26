package abc128.c;

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

    int lMax = 1;
    int rMin = n;
    for (int i = 0; i < m; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      lMax = Math.max(l, lMax);
      rMin = Math.min(r, rMin);
    }
    if (rMin < lMax) {
      os.println(0);
    } else {
      os.println(rMin - lMax + 1);
    }
  }
}