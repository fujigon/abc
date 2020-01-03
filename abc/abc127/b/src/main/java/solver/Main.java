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
    int r = sc.nextInt();
    int D = sc.nextInt();
    int x = sc.nextInt();

    for (int i = 1; i <= 10; i++) {
      x = r * x - D;
      os.println(x);
    }
  }
}