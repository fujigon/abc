import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static class LowerBoundComparator<T extends Comparable<? super T>>
          implements Comparator<T>
  {
    public int compare(T x, T y)
    {
      return (x.compareTo(y) >= 0) ? 1 : -1;
    }
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    List<Integer> l = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      l.add(sc.nextInt());
    }

    Collections.sort(l);
    int ans = 0;

    for (int ai = 0; ai < n - 2; ai++) {
      for (int bi = ai + 1; bi < n - 1; bi++) {
        int a = l.get(ai);
        int b = l.get(bi);

        int ci = - Collections.binarySearch(l, a + b, new LowerBoundComparator<>()) - 1;

        ans += (ci - 1) - bi;
      }
    }
    os.println(ans);
  }
}