package solver;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    String s = sc.next();

//    int res = 0;
//    for (int i = 0; i < n; i++) {
//      int l = i;
//      int r = i + 1;
//
//      while (r < n) {
//        while (r < n && s.charAt(l) != s.charAt(r)) r++;
//        if (r == n) break;
//        int w = 0;
//        while (l + w < r && r + w < n && s.charAt(l + w) == s.charAt(r + w)) w++;
//        res = Math.max(res, w);
//        r = r + 1;
//      }
//    }

    int len = n / 2;

    while (len > 0) {
      for (int l = 0; l <= n - 2 * len; l++) {
        for (int r = l + len; r <= n - len; r++) {
          String ls = s.substring(l, l + len);
          String rs = s.substring(r, r + len);
          if (ls.equals(rs)) {
            os.println(len);
            return;
          }
        }
      }
      len--;
    }
    os.println(len);


//    Map<Character, List<Integer>> headsMap = new HashMap<>();
//
//    int res = 0;
//
//    for (int i = 0; i < s.length(); i++) {
//      char c = s.charAt(i);
//      List<Integer> heads = headsMap.getOrDefault(c, new ArrayList<>());
//
//      for (int l : heads) {
//        int k = 0;
//        while (l + k < i && i + k < n && s.charAt(l + k) == s.charAt(i + k)) k++;
//        res = Math.max(res, k);
//      }
//
//      heads.add(i);
//      headsMap.put(c, heads);
//    }
//    os.println(res);
  }
}