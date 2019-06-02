package agc034.b;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    String s = sc.next();

    os.println(search(s));

  }

  private static long search(String s) {

    s = s.replaceAll("BC", "D");

    int n = s.length();

    long sum = 0;
    int j = 0;
    while (j < n){

      if (s.charAt(j) != 'A') {
        j++;
        continue;
      }

      // for each, find A
      // found A

      int aCount = 0;
      int i = j;
      while (i < n && (s.charAt(i) == 'A' || s.charAt(i) == 'D')) {
        if (s.charAt(i) == 'A') {
          aCount++;
        }
        if (s.charAt(i) == 'D') {
          sum += aCount;
        }
        i++;
      }
      j = i;
    }
    return sum;
  }
}