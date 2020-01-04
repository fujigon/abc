package abc.abc149.c;

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
    int x = sc.nextInt();
    
    while (true) {
      boolean isPrime = true;
      for (int i = 2; i <= Math.sqrt(x); i++) {
        if (x % i == 0) {
          isPrime = false;
          break;
        } 
      }
      if (isPrime) {
        os.println(x);
        return;
      }
      x++;
    }
  }
}