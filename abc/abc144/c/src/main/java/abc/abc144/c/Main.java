package abc.abc144.c;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    long n = sc.nextLong();

    int r = (int) Math.sqrt(n);

    long min = Long.MAX_VALUE;
    for (int i = 1; i <= r; i++) {
      if (n % i == 0) {
        long j = n / i;
        long val = i - 1 + j - 1;
        min = Math.min(min, val);
      }
    }
    os.println(min);
  }

}