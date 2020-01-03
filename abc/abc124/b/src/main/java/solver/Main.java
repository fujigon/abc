package solver;

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

    int h[] = new int[n];

    for (int i = 0; i < n; i++) {
      h[i] = sc.nextInt();
    }

    /* logic */

    int visible = 0;

    int highest = 0;

    for (int i = 0; i < n; i++) {
      if (h[i] >= highest) {
        highest = h[i];
        visible++;
      }
    }

    os.println(visible);
  }
}