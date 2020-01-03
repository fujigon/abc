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
    int n = sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();
    List<Integer> continued = new LinkedList<>();
    int i = 0;
    while (i < n) {
      int j = i + 1;
      while (j < n && s.charAt(j - 1) == s.charAt(j)) {
        j++;
      }
      continued.add(j - i);
      i = j;
    }

    while (0 < k && 0 < continued.size()) {
      if (2 < continued.size()) {
        int i1 = continued.remove(0);
        int i2 = continued.remove(0);
        int i3 = continued.remove(0);
        continued.add(0, i1 + i2 + i3);
      } else if (2 == continued.size()) {
        int i1 = continued.remove(0);
        int i2 = continued.remove(0);
        continued.add(0, i1 + i2);
      }
      k--;
    }

    int res = 0;
    for (int cont : continued) {
      res += cont - 1;
    }
    os.println(res);
  }
}