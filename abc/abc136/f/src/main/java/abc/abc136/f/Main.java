package abc.abc136.f;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static final long MOD = 1000000007L;

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    String s = sc.next();
    String t = sc.next();
    Set<Character> sChars = new HashSet<>();
    Set<Character> tChars = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      sChars.add(s.charAt(i));
    }
    for (int i = 0; i < t.length(); i++) {
      tChars.add(t.charAt(i));
    }

    // t contains char that is not in s.
    for (char c : tChars) {
      if (!sChars.contains(c)) {
        os.println(0);
        return;
      }
    }

    if (sChars.size() == tChars.size()) {
      String sCon = s;
      String tCon = t;
      while (sCon.length() != tCon.length()) {
        if (sCon.length() < tCon.length())
          sCon += sCon;
        else
          tCon += tCon;
      }
      if (sCon.equals(tCon)) {
        os.println(-1);
        return;
      }
    }
  }
}