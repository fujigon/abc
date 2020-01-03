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
    long a = sc.nextLong();
    long b = sc.nextLong();
    long k = sc.nextLong();
    
    long eatA = Math.min(k, a);
    a -= eatA;
    k -= eatA;
    
    long eatB = Math.min(k, b);
    b -= eatB;
    k -= eatB;
    os.println(a + " " + b);
  }
}