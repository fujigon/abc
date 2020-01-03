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
    int[] h = new int[n];
    for (int i = 0; i < n; i++) {
      h[i] = sc.nextInt();
    }
    for (int i = 1; i < n; i++) {
      if (h[i - 1] < h[i]) h[i]--;
      if (h[i] < h[i - 1]) {
        os.println("No");
        return;
      }
    }
    os.println("Yes");
  }
}
