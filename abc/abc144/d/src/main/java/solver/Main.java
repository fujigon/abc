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
    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double x = sc.nextDouble();

    double v = a * a * b;

    double d = 0;
    if (x <= v / 2) {
      double o = x; // occupied area
      double r = Math.PI / 2 - Math.atan2(2 * o, b * b * a);
      d = Math.toDegrees(r);
    } else {
      double e = v - x; // empty area
      double r = Math.atan2(2 * e, a * a * a);
      d = Math.toDegrees(r);
    }
    os.println(d);
  }

}