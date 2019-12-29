package pakencamp2019day3.b;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.LongStream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    long n = sc.nextLong();
    
    long black = LongStream.range(0, n).mapToObj(i -> sc.next())
        .filter(s -> s.equals("black"))
        .count();

    os.println(black > n - black ? "black" : "white");
  }
}