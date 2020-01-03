import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final long MOD = 1000000007L;


  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int w = sc.nextInt();
    int h = sc.nextInt();

    int x = sc.nextInt();
    int y = sc.nextInt();

    double area = (double) w * (double) h;
    area /= 2;

    int divide = (x * 2 == w) && (y * 2 == h) ? 1 : 0;

    os.print(String.format("%.6f", area) + " ");
    os.println(divide);
  }
}