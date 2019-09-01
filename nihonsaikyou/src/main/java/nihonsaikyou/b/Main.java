package nihonsaikyou.b;

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
    long k = sc.nextLong();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    long result = 0;
    for (int i = 0; i < n; i++) {
      long l = 0;
      long r = 0;

      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) l++;
      }

      for (int j = i + 1; j < n; j++) {
        if (a[i] > a[j]) r++;
      }

      result += calc(r, k, l + r);
      result %= MOD;
    }

    os.println(result);
  }

  private static long calc(long a, long n, long d) {
    long result = 0;
    result += (n * a) % MOD;
    result += (n * (n - 1) / 2) % MOD * d % MOD;
    return result % MOD;
//    return ((n * (2 * a + (n - 1) * d)) / 2) % MOD;
  }
}