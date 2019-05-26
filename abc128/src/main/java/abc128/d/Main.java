package abc128.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Change {

    int times;
    int toValue;

  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int m = sc.nextInt();

    List<Integer> values = new ArrayList<>(n);
    List<Change> changes = new ArrayList<>(m);

    for (int i = 0; i < n; i++) {
      values.add(sc.nextInt());
    }

    for (int i = 0; i < m; i++) {
      Change change = new Change();
      change.times = sc.nextInt();
      change.toValue = sc.nextInt();
      changes.add(change);
    }

    // logic

    values.sort(Integer::compareTo);
    changes.sort(Comparator.comparingInt(c -> c.toValue));
    Collections.reverse(changes);

    int i = 0;
    for (Change change : changes) {
      for (int j = 0; j < change.times; j++) {
        if (i == n) break;
        if (values.get(i) < change.toValue) {
          values.set(i, change.toValue);
        } else {
          break;
        }
        i++;
      }
    }

    long sum = 0;
    for (int value : values) {
      sum += value;
    }
    os.println(sum);
  }
}