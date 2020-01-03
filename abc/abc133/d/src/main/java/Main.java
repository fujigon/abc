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
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    int b = 0;
    for (int i = 1; i < n; i++) {
      b = 2 * (a[i - 1] - b / 2);
    }

    b = (a[n - 1] - b / 2);
    for (int i = 1; i < n; i++) {
      os.print(b + " ");
      b = 2 * (a[i - 1] - b / 2);
    }
    os.println(b);

  }
}