package abc104.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    String s = sc.next();
    int n = s.length();
    int[] leftAs = new int[n];
    int[] leftQs = new int[n];
    int[] rightCs = new int[n];
    int[] rightQs = new int[n];

    int qCount;

    int aCount = 0;
    qCount = 0;
    for (int i = 0; i < n; i++) {
      leftAs[i] = aCount;
      leftQs[i] = qCount;
      char c = s.charAt(i);
      if (c == 'A') aCount++;
      else if (c == '?') qCount++;
    }

    int cCount = 0;
    qCount = 0;
    for (int i = n - 1; 0 <= i; i--) {
      rightCs[i] = cCount;
      rightQs[i] = qCount;
      char c = s.charAt(i);
      if (c == 'C') cCount++;
      else if (c == '?') qCount++;
    }

    long[] pow3 = new long[qCount + 1];
    pow3[0] = 1;
    for (int i = 1; i <= qCount; i++) {
      pow3[i] = (pow3[i - 1] * 3L) % MOD;
    }

    long sum = 0;
    // fix B
    for (int i = 0 ; i < n; i++) {
      char c = s.charAt(i);
      if (c != 'B' && c != '?') continue;
      long left = leftAs[i] * pow3[leftQs[i]] % MOD;
      if (1 <= leftQs[i]) left += leftQs[i] * pow3[leftQs[i] - 1];
      long right = rightCs[i] * pow3[rightQs[i]] % MOD;
      if (1 <= rightQs[i]) right += rightQs[i] * pow3[rightQs[i] - 1];
      sum += (left % MOD) * (right % MOD);
      sum = sum % MOD;
    }
    os.println(sum);
  }
}