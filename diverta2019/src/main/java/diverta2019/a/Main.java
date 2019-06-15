package diverta2019.a;

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

    int p = sc.nextInt();
    int q = sc.nextInt();
    int r = sc.nextInt();

    os.println(p +  q + r - Math.max(Math.max(p, q), r));
  }
}