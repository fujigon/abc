package solver;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    long k = sc.nextLong();
    Long[] a = new Long[n];
    Long[] f = new Long[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextLong();
    }
    for (int i = 0; i < n; i++) {
      f[i] = sc.nextLong();
    }
    Arrays.sort(a, Comparator.naturalOrder());
    Arrays.sort(f, Comparator.reverseOrder());

    long ok = 1;
    while (!canFinish(ok, n, k, a, f)) ok *= 2;
    long ng = ok / 2 - 1;
    while (ok - ng > 1) {
      long mid = (ok + ng) / 2;
      if (canFinish(mid, n, k, a, f)) ok = mid;
      else ng = mid;
    }

    os.println(ok);
  }

  private static boolean canFinish(long time, int n, long k, Long[] a, Long[] f) {

    for (int i = 0; i < n; i++) {
      long c = time / f[i];
      k -= Math.max(a[i] - c, 0);
    }
    return k >= 0;
  }

  private static class Scanner {

    private final InputStream is;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    Scanner(InputStream is) {
      this.is = is;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = is.read(buffer);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) return buffer[ptr++];
      else return -1;
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) throw new NoSuchElementException();
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) throw new NoSuchElementException();
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      long nl = nextLong();
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
      return (int) nl;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
