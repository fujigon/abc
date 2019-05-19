package abc126.c;

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

    long[] lgcds = new long[n];
    long[] rgcds = new long[n];

    long gcd;
    gcd = 0;
    for (int i = 0; i < n; i++) {
      gcd = gcd(gcd, a[i]);
      lgcds[i] = gcd;
    }
    gcd = 0;
    for (int i = n - 1; 0 <= i; i--) {
      gcd = gcd(gcd, a[i]);
      rgcds[i] = gcd;
    }

    long maxGcd = Long.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      long lgcd = 0;
      long rgcd = 0;
      if (0 < i) {
        lgcd = lgcds[i - 1];
      }
      if (i < n - 1) {
        rgcd = rgcds[i + 1];
      }
      maxGcd = Math.max(gcd(lgcd, rgcd), maxGcd);
    }

    os.println(maxGcd);

  }

  private static long gcd(long m, long n) {
    if (m < n) {
      return gcd(n, m);
    }
    if (n == 0) {
      return m;
    }
    return gcd(n, m % n);
  }

}