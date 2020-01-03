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
    int d = sc.nextInt();

    List<int[]> points = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      int[] point = new int[d];
      for (int j = 0; j < d; j++) {
        point[j] = sc.nextInt();
      }
      points.add(point);
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int sqDist = 0;
        int[] p1 = points.get(i);
        int[] p2 = points.get(j);
        for (int k = 0; k < d; k++) {
          sqDist += (p1[k] - p2[k]) * (p1[k] - p2[k]);
        }
        int dist = (int) Math.sqrt(sqDist);
        if (dist * dist == sqDist) count++;
      }
    }

    os.println(count);
  }
}