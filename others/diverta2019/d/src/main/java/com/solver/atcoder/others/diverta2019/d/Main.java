package com.solver.atcoder.others.diverta2019.d;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    long n = sc.nextLong();

    long ans = 0;
    long sqrt = (long) Math.sqrt(n);
    for (long k = 1; k <= sqrt; k++) {
      if (n % k == 0) {
        long m = n / k - 1;
        if (k < m) ans += m;
      }
    }
    os.println(ans);
  }

  private static Set<Long> dividers(Map<Long, Long> factors) {
    Set<Long> ans = new HashSet<>();
    ans.add(1L);
    for (long fact : factors.keySet()) {
      for (int i = 0; i < factors.get(fact); i++) {
        Set<Long> next = new HashSet<>();
        next.addAll(ans);
        for (long d : ans) {
          next.add(d * fact);
        }
      }
    }
    return ans;
  }

  private static Map<Long, Long> factorize(long x) {
    Map<Long, Long> ans = new HashMap<>();
    long fact = 2;
    long sqrt = (long) Math.sqrt(x);
    while (1 < x && fact < sqrt) {
      long count = 0;
      while (x % fact == 0) {
        count++;
        x /= fact;
      }
      ans.put(fact, count);
    }
    if (x > 1) {
      ans.put(x, 1L);
    }
    return ans;
  }

  private static <P> List<P> bfs(P start, P end, Function<P, Set<P>> travel,
      Predicate<P> predicate) {
    Set<P> visited = new HashSet<>();
    Queue<List<P>> queue = new LinkedList<>();
    visited.add(start);
    queue.add(Collections.singletonList(start));

    while (!queue.isEmpty()) {
      List<P> path = queue.remove();
      P head = path.get(path.size() - 1);
      Set<P> candidates = travel.apply(head);
      for (P c : candidates) {
        if (!visited.contains(c) && predicate.test(c)) {
          List<P> p = Stream.concat(path.stream(), Stream.of(c)).collect(Collectors.toList());
          queue.add(p);
          visited.add(c);
          if (c.equals(end)) {
            return p;
          }
        }
      }
    }
    return null;
  }

  private static class FermatCombination {

    private long fact[];
    private long mod;

    public FermatCombination(int size, long mod) {
      this.fact = new long[size + 1];
      this.mod = mod;

      this.fact[0] = 1;

      for (int i = 1; i <= size; i++) {
        fact[i] = (fact[i - 1] * i) % mod;
      }
    }

    private long factorial(int n) {
      return fact[n];
    }

    private long inverse(long n) {
      return pow(n, mod - 2) % mod;
    }

    private long pow(long x, long n) {
      long ans = 1;
      while (n > 0) {
        if ((n & 1) == 1) {
          ans = ans * x % mod;
        }
        x = x * x % mod;
        n >>= 1;
      }
      return ans;
    }

    long combination(int n, int k) {
      long ans = 1;
      ans *= factorial(n);
      ans %= mod;
      ans *= inverse(factorial(n - k));
      ans %= mod;
      ans *= inverse(factorial(k));
      ans %= mod;
      return ans;
    }
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
      if (hasNextByte()) {
        return buffer[ptr++];
      } else {
        return -1;
      }
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
        ptr++;
      }
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
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
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
        throw new NumberFormatException();
      }
      return (int) nl;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
