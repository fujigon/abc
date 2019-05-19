package abc126.c;

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
    double n = sc.nextDouble();

    double k = sc.nextDouble();

    double result = 0;

    for (int i = 1; i <= n ; i++) {
      double r = 1.0d / n;
      int tmp = i;
      while (tmp < k) {
        tmp *= 2;
        r /= 2;
      }
      result += r;
    }
    os.println(result);
  }

}