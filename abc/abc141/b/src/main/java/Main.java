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

    boolean good = true;
    for (int i = 0; i < s.length(); i+= 2) {
      char c = s.charAt(i);
      if (c == 'L') good = false;
    }
    for (int i = 1; i < s.length(); i+= 2) {
      char c = s.charAt(i);
      if (c == 'R') good = false;
    }
    if (good) {
      os.println("Yes");
    } else {
      os.println("No");
    }
  }
}