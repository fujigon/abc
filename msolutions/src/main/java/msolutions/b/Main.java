package msolutions.b;

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
    int n = sc.nextInt();

    List<String> cities = new ArrayList<>(n);
    List<Integer> scores = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      cities.add(sc.next());
      scores.add(sc.nextInt());
    }

    IntStream.range(0, n)
        .boxed()
        .sorted((i1, i2) ->
            cities.get(i1).equals(cities.get(i2)) ? -scores.get(i1).compareTo(scores.get(i2)) :
                cities.get(i1).compareTo(cities.get(i2))
        ).map(i -> i + 1)
        .forEach(os::println);
  }
}