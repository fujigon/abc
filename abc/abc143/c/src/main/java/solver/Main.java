package solver;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    String s = sc.next();

    int l = 0;
    int r = 1;
    int ans = 0;
    while (l < s.length()) {
      while (r < s.length() && s.charAt(l) == s.charAt(r)) r++;
      ans++;
      l = r;
      r = l + 1;
    }
    os.println(ans);
  }

}