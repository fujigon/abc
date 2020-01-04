package com.solver.atcoder.abc.abc148.e;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    long n = sc.nextLong();
    
    if (n % 2 == 1) {
      os.println(0);
      return;
    }
    
    long ans = 0;
    
    long base = 10;
    
    while (base <= n) {
      ans += n / base;
      base *= 5;
    }
    
    os.println(ans);
  }
}