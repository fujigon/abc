package abc142.d;

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
    long a = sc.nextLong();
    long b = sc.nextLong();

    long target = gcd(a, b);

    Set<Long> factors = factorize(target);
    factors.add(1L);

    os.println(factors.size());
  }

  private static Set<Long> factorize(long n) {
    Set<Long> factors = new HashSet<>();
    long root = (long) Math.sqrt(n) + 1;
    for (long i = 2; i <= root; i++) {
      if (n % i != 0) continue;
      do {
        n /= i;

      } while (n % i == 0);
      factors.add(i);
    }
    factors.add(n);
    return factors;
  }

  private static long gcd(long m, long n) {
    if(m < n) return gcd(n, m);
    if(n == 0) return m;
    return gcd(n, m % n);
  }
}