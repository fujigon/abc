package com.solver.atcoder.others.abc113.c;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class City {
    int p;
    int y;
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int m = sc.nextInt();

    List<City> cities = new ArrayList<>(m);
    for (int i = 0; i < m; i++) {
      int p = sc.nextInt();
      int y = sc.nextInt();
      City c = new City();
      c.p = p;
      c.y = y;
      cities.add(c);
   }

    Map<Integer, List<City>> prefToCity = new HashMap<>();

    for (City c : cities) {
      List<City> list = prefToCity.getOrDefault(c.p, new ArrayList<>());
      list.add(c);
      prefToCity.put(c.p, list);
    }

    Map<City, Integer> indexOfPref = new HashMap<>();
    for (List<City> list : prefToCity.values()) {
      list.sort(Comparator.comparingInt(c -> c.y));
      for (int i = 0; i < list.size(); i++) {
        indexOfPref.put(list.get(i), i + 1);
      }
    }

    List<String> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      City c = cities.get(i);
      res.add(String.format("%06d%06d", c.p, indexOfPref.get(c)));
    }
    os.println(String.join(System.lineSeparator(), res));
  }
}
