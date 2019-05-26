package abc128.b;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    Map<String, List<Integer>> map = new HashMap<>();

    Map<String, Integer> restaurants = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String city = sc.next();
      int score = sc.nextInt();
      List<Integer> list = map.getOrDefault(city, new ArrayList<>());
      list.add(score);
      map.put(city, list);
      restaurants.put(city + score, i);
    }

    List<String> cities = new ArrayList<>(map.keySet());
    Collections.sort(cities);
    for (String city : cities) {
      List<Integer> scores = map.get(city);
      Collections.sort(scores);
      Collections.reverse(scores);
      for (int score : scores) {
        os.println(restaurants.get(city + score) + 1);
      }
    }
  }
}