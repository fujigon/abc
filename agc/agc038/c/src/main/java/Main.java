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
    int k = sc.nextInt();
    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    SortedSet<Integer> set = new TreeSet<>();

    // find already k-length ordered segment
    Set<Integer> orderedIndexes = new HashSet<>();
    int l = 0;
    int r = 1;
    for (l = 0; l < n; l++) {
      if (l == r) r++;
      while (r < n && a[r - 1] < a[r]) r++;
      if (k <= r - l) orderedIndexes.add(l);
    }

    for (int i = 0; i < k; i++) {
      set.add(a[i]);
    }

    int start = 0;

    int res = n - k + 1;

    while (start + k < n) {
      int min = set.first();
      int max = set.last();
      set.remove(a[start]);
      set.add(a[start + k]);
      if (min == a[start] && max < a[start + k]) res--;

      start++;
    }

    if (orderedIndexes.size() > 1) {
      res -= orderedIndexes.size() - 1;
    }

    os.println(res);

  }

}