package abc.abc124.c;

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
    String s = sc.next();

    boolean[] sbool = new boolean[s.length()];

    for (int i = 0; i < s.length(); i++) {
      sbool[i] = s.charAt(i) == '1';
    }

    /* logic */
    boolean[] candidate0 = generateCandidate(false, s.length());
    boolean[] candidate1 = generateCandidate(true, s.length());

    int diffOfCandidate0 = calcDiff(sbool, candidate0);
    int diffOfCandidate1 = calcDiff(sbool, candidate1);

    os.println(Math.min(diffOfCandidate0, diffOfCandidate1));
  }

  private static boolean[] generateCandidate(boolean initialZero, int length) {
    boolean[] candidate = new boolean[length];
    boolean isZero = initialZero;
    for (int i = 0; i < length; i++) {
      candidate[i] = isZero;
      isZero = !isZero;
    }
    return candidate;
  }

  private static int calcDiff(boolean[] s1, boolean[] s2) {

    int diff = 0;
    for (int i = 0; i < s1.length; i++) {
      if (s1[i] != s2[i]) {
        diff++;
      }
    }

    return diff;

  }

}