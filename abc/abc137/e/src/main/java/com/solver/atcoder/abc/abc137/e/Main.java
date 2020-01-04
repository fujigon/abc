package com.solver.atcoder.abc.abc137.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    long k = sc.nextLong();

    int[] a = new int[n];

    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      sum += a[i];
    }

    for (int divS = 1; divS <= sum; divS++) {
      if (sum % divS != 0) continue;
      int divL = sum / divS;
      if (isValid(divL, k, n, a)) {
        os.println(divL);
        return;
      }
    }
  }

  private static boolean isValid(int d, long k, int n, int[] a) {
    int[] rest = new int[n];
    for (int i = 0; i < n; i++) {
      int r = a[i] % d;
      rest[i] = r;
      if (k < r && k < d - r) return false;
    }

    int count = 0;
    Arrays.sort(rest);
    int remain = 0;
    int l = 0;
    int r = n - 1;
    while(l <= r) {
      if (0 <= remain) {
        int val = rest[r];
        remain += val - d;
        count += d - val;
        r--;
      } else {
        int val = rest[l];
        remain += val;
        count += val;
        l++;
      }
    }
    return count <= 2 * k;
  }
}