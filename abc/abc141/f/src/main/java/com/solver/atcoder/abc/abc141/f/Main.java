package com.solver.atcoder.abc.abc141.f;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
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

    long red = 0;
    long blu = 0;

    Queue<Long> queue = new PriorityQueue<>((l1, l2) -> -l1.compareTo(l2));

    for (int i = 0; i < n; i++) {
      queue.add(sc.nextLong());
    }

    while (!queue.isEmpty()) {
      long val = queue.remove();
      long redXor = red ^ val;
      long bluXor = blu ^ val;
      if(redXor + blu > red + bluXor) {
        red ^= val;
      } else {
        blu ^= val;
      }
    }


//    int[] bits = new int[60];
//
//    for (int i = 0; i < n; i++) {
//      long a = sc.nextLong();
//
//      for (int b = 0; b < 60; b++) {
//        bits[b] += (a >> b) & 1;
//      }
//    }
//    long red = 0;
//    long blue = 0;
//    for (int b = 0; b < 60; b++) {
//      if (bits[b] == 0) continue;
//      if (bits[b] % 2 == 0) {
//        blue += 1 << b;
//      }
//      red += 1 << b;
//    }
    os.println(red + blu);
  }
}