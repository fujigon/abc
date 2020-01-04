package com.solver.atcoder.agc.agc034.d;

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
    int k = sc.nextInt();

    int[] values = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = sc.nextInt();
    }

    int max = 0;
    for (int leftOperation = 0; leftOperation <= k; leftOperation++) {
      int rightOperation = k - leftOperation;

      for (int leftTaking = 0; leftTaking <= Math.min(leftOperation, n); leftTaking++) {
        for (int rightTaking = 0; rightTaking <= Math.min(Math.min(rightOperation, n - leftTaking), n); rightTaking++) {
          int leftDrop = Math.min(leftTaking, leftOperation - leftTaking);
          int rightDrop = Math.min(rightTaking, rightOperation - rightTaking);

          List<Integer> left = new ArrayList<>();
          for (int i = 0; i < leftTaking; i++) {
            left.add(values[i]);
          }
          List<Integer> right = new ArrayList<>();
          for (int i = 0; i < rightTaking; i++) {
            right.add(values[n - 1 - i]);
          }
          Collections.sort(left);
          Collections.sort(right);
          while (left.size() > 0 && leftDrop > 0 && left.get(0) < 0) {
            left.remove(0);
            leftDrop--;
          }
          while (right.size() > 0 && rightDrop > 0 && right.get(0) < 0) {
            right.remove(0);
            rightDrop--;
          }
          int sum = 0;
          for (int l : left) {
            sum += l;
          }
          for (int r : right) {
            sum += r;
          }
          max = Math.max(max, sum);
        }
      }
    }

    os.println(max);
  }
}