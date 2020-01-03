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

    int count = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'A' || c == 'T' || c == 'G' || c == 'C') {
        count++;
        max = Math.max(count, max);
      } else {
        count = 0;
      }
    }

    os.println(max);
  }
}