package abc136.c;

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
    int[] a = new int[n + 1];
    int[] b = new int[n];

    for (int i = 0; i < n + 1; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
    }

    long sum = 0;

    long remain = 0;
    long kill;
    for (int i = 0; i < n; i++) {
      if (a[i] <= remain) {
        kill = a[i];
        remain = b[i];
      } else {
        kill = Math.min(a[i], remain + b[i]);
        remain = b[i] - (kill - remain);
      }
      sum += kill;
    }
    kill = Math.min(a[n], remain);
    sum += kill;

    os.println(sum);
  }
}

//package abc136.c;
//
//import java.io.InputStream;
//import java.io.PrintStream;
//import java.util.*;
//
//public class Main {
//
//  public static void main(String[] args) {
//    solve(System.in, System.out);
//  }
//
//  static void solve(InputStream is, PrintStream os) {
//    Scanner sc = new Scanner(is);
//
//    /* read */
//
//    int n = sc.nextInt();
//    int[] a = new int[n + 1];
//    int[] b = new int[n];
//
//    for (int i = 0; i < n + 1; i++) {
//      a[i] = sc.nextInt();
//    }
//    for (int i = 0; i < n; i++) {
//      b[i] = sc.nextInt();
//    }
//
//    int sum = 0;
//
//    int killable = 0;
//    int kill;
//    for (int i = 0; i < n; i++) {
//      int monster = a[i];
//      monster = Math.max(0, monster - killable);
//      kill = Math.min(monster, b[i]);
//      if (a[i] <= killable) {
//        kill = a[i];
//        killable = b[i];
//      } else {
//        kill = Math.min(a[i], killable + b[i]);
//        killable = b[i] - (kill - killable);
//      }
//      sum += kill;
//    }
//    kill = Math.min(a[n], killable);
//    sum += kill;
//
//    os.println(sum);
//  }
//}