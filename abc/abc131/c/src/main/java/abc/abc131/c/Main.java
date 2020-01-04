package abc.abc131.c;

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
    long a = sc.nextLong();
    long b = sc.nextLong();

    long c = sc.nextLong();
    long d = sc.nextLong();

    a--;

    long cumA = a - (a / c + a / d - a / lcm(c, d));
    long cumB = b - (b / c + b / d - b / lcm(c, d));

    os.println(cumB - cumA);
  }

  static long lcm(long a, long b) {
    return a / gcd(a, b) * b;
  }

  static long gcd(long a, long b) {
    long r;
    while( (r = a % b) != 0 ) {
      a = b;
      b = r;
    }
    return b;
  }
}