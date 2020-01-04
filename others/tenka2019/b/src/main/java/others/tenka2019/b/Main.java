package others.tenka2019.b;

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
    String s = sc.next();
    int k = sc.nextInt();

    /* logic */

    String answer = "";
    char c = s.charAt(k - 1);
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != c) {
        answer = answer + "*";
      } else {
        answer = answer + c;
      }
    }
    os.println(answer);
  }
}