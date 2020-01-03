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
    int k = sc.nextInt();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int h = sc.nextInt();
      if (k <= h) ans++;
    }
    os.println(ans);
  }
}