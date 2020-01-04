package com.solver.atcoder.others.diverta2019.c;

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

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    List<Long> negatives = new LinkedList<>();
    List<Long> positives = new LinkedList<>();
    int zeros = 0;

    for (long num : a) {
      if (num < 0) negatives.add(num);
      if (num > 0) positives.add(num);
      if (num == 0) zeros++;
    }

    while (zeros > 0) {
      if (positives.size() > negatives.size()) {
        negatives.add(0L);
      } else {
        positives.add(0L);
      }
      zeros--;
    }

    negatives.sort(Long::compareTo);
    positives.sort(Long::compareTo);

    List<long[]> operations = new ArrayList<>(n - 1);

    while (negatives.size() + positives.size() > 1) {
      if (negatives.size() == 0) {
        // create positives
        long min = positives.remove(0);
        long max = positives.remove(positives.size() - 1);
        long val = min - max;
        long[] operation = new long[2];
        operation[0] = min;
        operation[1] = max;
        operations.add(operation);

        negatives.add(val);
        // TODO
        negatives.sort(Long::compareTo);
      } else if (positives.size() == 0) {
        // create negatives
        long min = negatives.remove(0);
        long max = negatives.remove(negatives.size() - 1);
        long val = max - min;
        long[] operation = new long[2];
        operation[0] = max;
        operation[1] = min;
        operations.add(operation);

        positives.add(val);
        // TODO
        positives.sort(Long::compareTo);
      } else if (positives.size() > negatives.size() ) {
        long min = negatives.remove(0);
        long max = positives.remove(positives.size() - 1);

        long[] operation = new long[2];
        operation[0] = min;
        operation[1] = max;
        operations.add(operation);

        negatives.add(0, min - max);
      } else {
        long min = negatives.remove(0);
        long max = positives.remove(positives.size() - 1);

        long[] operation = new long[2];
        operation[0] = max;
        operation[1] = min;
        operations.add(operation);

        positives.add(max - min);
      }
    }
    if (positives.size() > 0) {
      os.println(positives.get(0));
    } else {
      os.println(negatives.get(0));
    }
    for (long[] operation : operations) {
      os.println(operation[0] + " " + operation[1]);
    }
  }
}