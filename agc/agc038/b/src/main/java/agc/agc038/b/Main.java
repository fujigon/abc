package agc.agc038.b;

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

    // find already k-length ordered segment
    Set<Integer> ordered = new HashSet<>();
    int l = 0;
    int r = 1;
    for (l = 0; l < n; l++) {
      if (l == r) r++;
      while (r < n && a[r - 1] < a[r]) r++;
      if (k <= r - l) ordered.add(l);
    }

    SortedSet<Integer> set = new TreeSet<>();

    for (int i = 0; i < k; i++) {
      set.add(a[i]);
    }

    int res = n - k + 1;

    for (int i = 0; i < n - k; i++) {
      int min = set.first();
      int max = set.last();
      set.remove(a[i]);
      set.add(a[i + k]);
      if (min == a[i] && max < a[i + k] && !ordered.contains(i)) res--;
    }

    if (ordered.size() > 1) {
      res -= ordered.size() - 1;
    }
    os.println(res);

  }

}