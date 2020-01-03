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
    int[] a = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = sc.nextInt();
    }

    int m = 0;
    List<Integer> turnOn = new ArrayList<>();
    int[] b = new int[n + 1];
    for (int i = n; 1 <= i; i--) {
      int val = a[i];
      for (int j = 2 * i; j <= n; j += i) {
        val += b[j];
      }
      b[i] = val % 2;
      if (b[i] == 1) {
        m++;
        turnOn.add(i);
      }
    }

    os.println(m);
    if (m > 0) {
      os.println(turnOn.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
  }
}