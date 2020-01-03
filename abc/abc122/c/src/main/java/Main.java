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

    int q = sc.nextInt();
    String s = sc.next();

    // zero-origin
    int[] l = new int[q];
    int[] r = new int[q];

    for (int i = 0; i < q; i++) {
      l[i] = sc.nextInt() - 1;
      r[i] = sc.nextInt() - 1;
    }

    List<Integer> acLeftIndexes = new ArrayList<>();

    // number of occurrence of AC [0.. i)
    int[] occurrences = new int[n];

    int occurrence = 0;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i - 1) == 'A' && s.charAt(i) == 'C') {
        occurrence++;
      }
      occurrences[i] = occurrence;
    }

    for (int i = 0; i < q; i++) {
      os.println(occurrences[r[i]] - (occurrences[l[i]]));
    }
  }

}