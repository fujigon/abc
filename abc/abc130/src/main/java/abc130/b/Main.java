package abc131.b;

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
    int n = sc.nextInt();

    int x = sc.nextInt();

    int d = 0;

    int count = 0;
    if (d <= x) {
      count++;
    }
    for (int i = 1; i <= n; i++) {
      int l = sc.nextInt();
      d = d + l;
      if (d <= x) {
        count++;
      }
    }
    os.println(count);
  }
}