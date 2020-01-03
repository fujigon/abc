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
    int q = sc.nextInt();

    int[] scores = new int[n];

    for (int i = 0; i < q; i++) {
      int a = sc.nextInt() - 1;
      scores[a]++;
    }

    for (int i = 0; i < n; i++) {
      int p = k - (q - scores[i]);
      if (p > 0) {
        os.println("Yes");
      } else {
        os.println("No");
      }
    }
  }

}