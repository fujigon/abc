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
    int d = sc.nextInt();

    int div = 2 * d + 1;

    int ans = 0;
    if (n % div == 0) {
      ans = n / div;
    } else {
      ans = n / div + 1;
    }

    os.println(ans);
  }
}