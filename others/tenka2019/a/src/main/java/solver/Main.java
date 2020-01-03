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

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    if (a < c && c < b) {
      os.println("Yes");
      return;
    }

    if (b < c && c < a) {
      os.println("Yes");
      return;
    }

    os.println("No");
  }
}