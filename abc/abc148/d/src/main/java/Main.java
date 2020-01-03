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
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    
    int breaking = 0;
    int target = 1;
    
    for (int i = 0; i < n; i++) {
      if (a[i] == target) {
        target++;
      } else {
        breaking++;
      }
    }
    if (breaking == n) {
      os.println(-1);
    } else {
      os.println(breaking);
    }
  }
}