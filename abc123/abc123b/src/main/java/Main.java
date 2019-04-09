import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);
    int w[] = new int[5];

    for (int i = 0; i < w.length; i++) {
      w[i] = sc.nextInt();
    }

    int lastIndex = 0;

    int lastIndexDigit = 10;

    for (int i = 0; i < w.length; i++) {
      int digit = w[i] % 10;
      if (digit != 0 && digit < lastIndexDigit) {
        lastIndex = i;
        lastIndexDigit = digit;
      }
    }

    int count = 0;

    for (int i = 0; i < w.length; i++) {
      if (i == lastIndex) {
        count += w[i];
      } else {
        count += (w[i] + (10 - 1)) / 10 * 10;
      }
    }

    os.println(count);
  }
}