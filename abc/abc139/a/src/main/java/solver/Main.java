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
    String s = sc.next();
    String t = sc.next();
    int res = 0;
    for (int i = 0; i < 3; i++) {
      if (s.charAt(i) == t.charAt(i)) res++;
    }
    os.println(res);
  }
}