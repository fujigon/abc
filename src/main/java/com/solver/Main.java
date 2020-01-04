package com.solver;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

// This is a dummy class for workaround to detect java_test of bazel for child projects.
public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    String s = sc.next();
    String t = sc.next();    
    
    os.println(t + s);
  }
}
