package abc.abc121.c;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Pair {
    long price;
    long num;
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int m = sc.nextInt();

    Queue<Pair> pairs = new PriorityQueue<>(Comparator.comparing(p -> p.price));

    for (int i = 0; i < n; i++){
      Pair pair = new Pair();
      pair.price = sc.nextLong();
      pair.num = sc.nextLong();
      pairs.add(pair);
    }

    int remain = m;
    long cost = 0;
    while (!pairs.isEmpty()) {
      Pair reasonable = pairs.remove();
      if (remain > reasonable.num ) {
        cost += reasonable.price * reasonable.num;
        remain -= reasonable.num;
      } else {
        cost += reasonable.price * remain;
        os.println(cost);
        return;
      }
    }
  }

}