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
    int h = sc.nextInt();
    int w = sc.nextInt();

    int a = sc.nextInt();
    int b = sc.nextInt();

    int[] r = new int[h];
    int[] c = new int[w];

    int[][] matrix = new int[h][w];

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if ((r[y] < w - a) && (c[x] < h - b)) {
          matrix[y][x] = 1;
          r[y]++;
          c[x]++;
        }
      }
    }

    for (int i = 0; i < h; i++) {
      if (r[i] != a && r[i] != w - a) {
        os.println("No");
        return;
      }
    }
    for (int i = 0; i < w; i++) {
      if (c[i] != b && c[i] != h - b) {
        os.println("No");
        return;
      }
    }
    for (int y = 0; y < h; y++) {
      StringBuilder s = new StringBuilder();
      for (int x = 0; x < w; x++) {
        s.append(matrix[y][x]);
      }
      os.println(s);
    }
  }
}