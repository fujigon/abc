package abc137.d;

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
    int m = sc.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    List<Integer> index = new ArrayList<>(n);
    for (int i = 0; i < n; i++) index.add(i);
    index.sort(Comparator.comparingInt(i -> a[i]));

    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> -b[index.get(i)]));
    long ans = 0;
    int i = 0;
    for (int d = 1; d <= m; d++) {
      while (i < n && a[index.get(i)] == d) queue.add(i++);
      if (!queue.isEmpty()) ans += b[index.get(queue.remove())];
    }
    os.println(ans);
  }
}