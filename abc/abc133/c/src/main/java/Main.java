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
    long l = sc.nextLong();
    long r = sc.nextLong();

    if (2019 <= r - l) {
      os.println("0");
      return;
    }

    long min = Long.MAX_VALUE;
    for (long i = l; i < r; i++) {
      for (long j = i + 1; j <= r; j++) {
        min = Math.min(min, i * j % 2019);
      }
    }

    os.println(min);
  }
}