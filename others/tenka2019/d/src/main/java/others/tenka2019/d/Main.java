package others.tenka2019.d;

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

    int[] a = new int[n];
    int allSum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      allSum += a[i];
    }

    long sumR = 0;
    long sumG = 0;
    long sumB = 0;
    List<Integer> r = new ArrayList<>();
    List<Integer> g = new ArrayList<>();
    // TODO
    os.println();
  }
}