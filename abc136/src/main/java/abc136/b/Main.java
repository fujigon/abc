package abc136.b;

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

    int diff = 0;
    for (int i = 1; i <= n; i++) {
      int p = sc.nextInt();
      if (p != i) diff++;
    }
    if (diff == 2 || diff == 0) {
      os.println("YES");
    } else {
      os.println("NO");
    }
  }
}