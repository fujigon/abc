package abc.abc130.a;

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

    int x = sc.nextInt();
    int a = sc.nextInt();

    if (x < a) {
      os.println("0");
    } else {
      os.println("10");
    }

  }
}