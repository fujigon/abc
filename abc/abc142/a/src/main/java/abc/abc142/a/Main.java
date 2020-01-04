package abc.abc142.a;

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
    double ans;
    if (n % 2 == 0) {
      ans = 0.5;
    } else {
      int odd = n / 2 + 1;
      ans = (double) odd / (double) n;
    }
    os.println(String.format("%.10f", ans));
  }
}