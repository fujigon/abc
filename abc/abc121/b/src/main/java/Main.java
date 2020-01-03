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
    int m = sc.nextInt();
    int c = sc.nextInt();

    int[] b = new int[m];
    int[][] a = new int[n][m];

    for (int i = 0; i < m; i++) {
      b[i] = sc.nextInt();
    }

    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        a[j][i] = sc.nextInt();
      }
    }

    int count = 0;
    for (int j = 0; j < n; j++) {
      int sum = c;
      for (int i = 0; i < m; i++) {
        sum += a[j][i] * b[i];
      }
      if (sum > 0) {
        count++;
      }
    }

    os.println(count);
  }
}