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
    long n = sc.nextLong();
    long cap[] = new long[5];

    for (int i = 0; i < 5; i++) {
      cap[i] = sc.nextLong();
    }

    /* logic */
    int botttleneckIndex = 0;
    long bottoleneck = Long.MAX_VALUE;

    for (int i = 0; i < cap.length; i++) {
      if (cap[i] < bottoleneck) {
        botttleneckIndex = i;
        bottoleneck = cap[i];
      }
    }

    long count = (n + bottoleneck - 1) / bottoleneck + 4;

    os.println(count);
  }

}