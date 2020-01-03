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
    int k = sc.nextInt();
    int x = sc.nextInt();

    List<String> ans = new ArrayList<>();
    for (int i = Math.max(-1000000, x - k + 1); i <= Math.min(1000000, x + k - 1); i++) {
      ans.add(String.valueOf(i));
    }
    os.println(String.join(" ", ans));
  }
}