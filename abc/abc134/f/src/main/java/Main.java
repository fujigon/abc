import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    long n = sc.nextInt();
    long k = sc.nextInt();

    long[] dp = new long[(int) (n * n)];

    if (k % 2 == 1) {
      os.println(0);
      return;
    }

    os.println(powerCombination(n, k/2));
  }

  private static long powerCombination(long n, long k) {
    if (k == 0) return 1;
    if (k == 1) return combination(n, k);

    int ans = 0;
    ans += combination(n - k, 1);
    for (int i = 1; i < k; i++) {
      ans += combination(n - k, 1);
    }
    return ans;
  }



  private static long combination(long n, long k) {
    if (k == 0) return 1;
    if (k == n) return 1;
    if (k < 0 || n < k) return 0;
    long ans = 1;
    for (int i = 1; i <= k; i++) {
      ans *= n - i + 1;
      ans /= i;
    }
    return ans % MOD;
  }
}