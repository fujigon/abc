package com.solver.atcoder.abc.abc149.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    long m = sc.nextLong();
    
    List<Long> a = new ArrayList<>(n);
    
    for (int i = 0; i < n; i++) {
      a.add(sc.nextLong());
    }
    a.sort(Comparator.reverseOrder());
    List<Long> culm = new ArrayList<>(n + 1);
    culm.add(0L);
    for (int i = 0; i < n; i++) {
      culm.add(culm.get(i) + a.get(i));
    }
    
    int s = 1;
    while ((long) (s + 1) * (long) (s + 1) + 2 * (long) (s + 1) * (n - s) < m) {
      s++;
    }
    
    long ans = 0;
    ans += culm.get(s) + culm.get(s);
    Queue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
    
    for (int i = 0; i < s; i++) {
      for (int j = s; j < n; j++) {
        queue.add(a.get(i) + a.get(j));
      }
    }

    for (int i = 0; i < s; i++) {
      for (int j = s; j < n; j++) {
        queue.add(a.get(i) + a.get(j));
      }
    }
    
    long remain = m - s * s;
    for (int i = 0; i < remain; i++) {
      ans += queue.remove();
    }
    
    os.println(ans);
  }
}