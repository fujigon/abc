package com.solver.atcoder.others.arc080.b;

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
    int h = sc.nextInt();
    int w = sc.nextInt();
    int n = sc.nextInt();

    int a[] = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    List<Integer> list = new ArrayList<>(w * h);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < a[i]; j++) {
        list.add(i + 1);
      }
    }

    boolean reverse = false;
    List<String> lines = new ArrayList<>(h);
    for (int i = 0; i < h; i++) {
      List<Integer> line = list.subList(i * w, (i + 1) * w);
      if (reverse)
        Collections.reverse(line);
      lines.add(line.stream().map(String::valueOf).collect(Collectors.joining(" ")));
      reverse = !reverse;
    }
    os.println(String.join(System.lineSeparator(), lines));
  }
}
