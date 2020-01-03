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

    int res = 0;
    for (int i = 1; i <= n; i++) {
      int d = 0;
      int v = i;
      while (v > 0) {
        v /= 10; d++;
      }
      if (d % 2 == 1) res++;
    }
    os.println(res);
  }
}