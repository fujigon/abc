package abc.abc125.b;

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

    int v[] = new int[n];
    int c[] = new int[n];

    for (int i = 0; i < n; i++) {
      v[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      c[i] = sc.nextInt();
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (v[i] > c[i]) {
        sum += v[i] - c[i];
      }
    }
    os.println(sum);
  }
}