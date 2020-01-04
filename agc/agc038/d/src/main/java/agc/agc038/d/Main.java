package agc.agc038.d;

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

    Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> -i1.compareTo(i2));

    for (int i = 0; i < n; i++) {
      queue.add(sc.nextInt());
    }

    for (int i = 0; i < m; i++) {
      int max = queue.remove();
      queue.add(max/2);
    }

    long res = 0;
    while(!queue.isEmpty()) {
      res += queue.remove();
    }

    os.println(res);
  }
}