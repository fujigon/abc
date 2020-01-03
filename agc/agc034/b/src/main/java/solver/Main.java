package solver;

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
//  private static long search(String s) {
//
//    int n = s.length();
//
//    long sum = 0;
//    int j = 0;
//    while (0 <= j &&j < n){
//
//      if (s.charAt(j) != 'A') {
//        j = s.indexOf("A", j + 1);
//        continue;
//      }
//
//      // for each, find A
//      // found A
//
//      int aCount = 0;
//      int i = j;
//      while (i < n && (s.charAt(i) == 'A' || i < n - 1 && (s.charAt(i) == 'B' && s.charAt(i + 1) == 'C'))) {
//        if (s.charAt(i) == 'A') {
//          aCount++;
//          i++;
//        } else {
//          sum += aCount;
//          i += 2;
//        }
//      }
//      j = i;
//    }
//    return sum;
//  }

  private static long search(String s) {

    int n = s.length();
    char[] c = s.toCharArray();

    long sum = 0;
    int j = 0;
    while (0 <= j && j < n) {

      // for each, find A
      // found A
      if (c[j] != 'A') {
        j = s.indexOf("A", j + 1);
        continue;
      }

      int aCount = 0;
      int i = j;
      while (i < n) {
        if (c[i] == 'A') {
          aCount++;
          i++;
        } else if (i + 1 < n && c[i] == 'B' && c[i + 1] == 'C') {
          i += 2;
          sum += aCount;
        } else {
          break;
        }
      }
      j = i;
    }
    return sum;
  }
}