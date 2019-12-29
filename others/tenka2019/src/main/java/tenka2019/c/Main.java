package tenka2019.c;

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
    String s = sc.next();
    boolean[] b = new boolean[n];

    for (int i = 0 ; i < n; i++) {
      if (s.charAt(i) == '#') { // black
        b[i] = false;
      } else { // white
        b[i] = true;
      }
    }

    /* logic */

    // first target is all false.
    int count = 0;
    for (int i = 0; i < n; i++){
      if (b[i]) {
        count++;
      }
    }

    int answer = count;
    for (int i = 0; i < n; i++){
      // target is [0..i] is true, [i + 1..n - 1]  is false
      // i index should be true
      if (!b[i]) {
        count++;
      } else {
        count--;
      }
      answer = Math.min(answer, count);
    }
    os.println(answer);

  }
}