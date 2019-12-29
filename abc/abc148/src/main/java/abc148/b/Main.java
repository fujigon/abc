package abc149.b;

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
    String t = sc.next();
    
    String res = "";
    
    for (int i = 0; i < n; i++) {
      res += s.charAt(i) + "" + t.charAt(i);
    }
    
    os.println(res);
  }
}