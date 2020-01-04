package others.msolutions.b;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    String s = sc.next();

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'o')
        count++;
    }

    if ((15 - s.length ()) + count >= 8) {
      os.println("YES");
    } else {
      os.println("NO");
    }
  }
}