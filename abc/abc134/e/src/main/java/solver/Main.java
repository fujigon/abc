package solver;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static class LowerBoundComparator<T extends Comparable<? super T>>
      implements Comparator<T>
  {
    public int compare(T x, T y)
    {
      return (x.compareTo(y) >= 0) ? 1 : -1;
    }
  }


  public static class UpperBoundComparator<T extends Comparable<? super T>>
      implements Comparator<T>
  {
    public int compare(T x, T y)
    {
      return (x.compareTo(y) > 0) ? 1 : -1;
    }
  }

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int[] a = new int[n];

    List<Integer> groups = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
//      int j = groups.size() - 1;
//      while (0 <= j && groups.get(j) <= a[j]) {
//        j--;
//      }
      int j = Collections.binarySearch(groups, a[i], new LowerBoundComparator<>());
//      if (0 <= j) {
//        groups.set(j, a[i]);
//      } else {
//        groups.add(0, a[i]);
//      }
      if (j == -1) {
        groups.add(0, a[i]);
      } else {
        groups.set(~j - 1, a[i]);
      }
    }

    os.println(groups.size());
  }
}