package pakencamp2019day3.e;

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
    int h = sc.nextInt();
    int w = sc.nextInt();
    
    boolean[][] occupied = new boolean[h][w]; 
    
    for (int j = 0; j < h; j++) {
      String line = sc.next();
      for (int i = 0; i < w; i++) {
        occupied[j][i] = line.charAt(i) == '#';
      }
    }
    
    int[][] horizontalAvailabilities = new int[h][w];
    int[][] verticalAvailabilities = new int[h][w];
    
    for (int j = 0; j < h; j++) {
      int l = 0;
      int r = 0;
      while (r < w) {
        while (r < w && occupied[j][l]) {
          l++;
          r++;
        }
        while (r < w && !occupied[j][r]) {
          r++;
        }
        while (l < r) {
          horizontalAvailabilities[j][l] = r - l;
          l++;
        }
        r = l + 1;
      }
    }

    for (int i = 0; i < w; i++) {
      int l = 0;
      int r = 0;
      while (r < h) {
        while (r < h && occupied[l][i]) {
          l++;
          r++;
        }
        while (r < h && !occupied[r][i]) {
          r++;
        }
        while (l < r) {
          verticalAvailabilities[l][i] = r - l;
          l++;
        }
        r = l + 1;
      }
    }

    int q = sc.nextInt();

    for (int k = 0; k < q; k++) {
      int y = sc.nextInt() - 1;
      int x = sc.nextInt() - 1;
      int l = sc.nextInt();
      boolean[][] v = new boolean[h][w];

      os.println(visit(x, y, l, w, h, v, horizontalAvailabilities, verticalAvailabilities, 0));
    }

  }
  
  private static long visit(int x, int y, int l, int w, int h, boolean[][] visited, int[][] horizontal, int[][] vertical, int count) {
    if (x < 0 || w <= x + l - 1) return count;
    if (y < 0 || h <= y + l - 1) return count;
    if (visited[y][x]) return count;
    if (horizontal[y][x] < l) return count;
    if (horizontal[y + l - 1][x] < l) return count;
    if (vertical[y][x] < l) return count;
    if (vertical[y][x + l - 1] < l) return count;
    visited[y][x] = true;
    long L = visit(x - 1, y, l, w, h, visited, horizontal, vertical, 0);
    long R = visit(x + 1, y, l, w, h, visited, horizontal, vertical, 0);
    long U = visit(x, y - 1, l, w, h, visited, horizontal, vertical, 0);
    long D = visit(x, y + 1, l, w, h, visited, horizontal, vertical, 0);
    return 1 + L + R + U + D;
  }
}