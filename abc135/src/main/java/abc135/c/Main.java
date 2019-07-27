package abc135.c;

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
    int fstMax = Integer.MIN_VALUE;
    int scdMax = Integer.MIN_VALUE;

    int a[] = new int[n];

    for (int i = 0; i < n; i++) {
      int val = sc.nextInt();
      a[i] = val;

      if (val >= fstMax) {
        scdMax = fstMax;
        fstMax = val;
      } else if (val >= scdMax) {
        scdMax = val;
      }
    }

    for (int i = 0; i < n; i++) {
      if (a[i] != fstMax) {
        os.println(fstMax);
      } else {
        os.println(scdMax);
      }
    }
  }
}