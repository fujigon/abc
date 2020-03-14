package com.solver.atcoder.others.hitachi2020.c;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class TreeNode {
    int node;
    int level;
    Set<TreeNode> children = new HashSet<>();
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    Queue<Integer> mod0 = new ArrayDeque<>();
    Queue<Integer> mod1 = new ArrayDeque<>();
    Queue<Integer> mod2 = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      int mod = i % 3;
      if (mod == 0) {
        mod0.add(i);
      } else if (mod == 1) {
        mod1.add(i);
      } else {
        mod2.add(i);
      }
    }
    Map<Integer, Set<Integer>> tree = new HashMap<>();

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      Set<Integer> aTo = tree.getOrDefault(a, new HashSet<>());
      aTo.add(b);
      tree.put(a, aTo);
      Set<Integer> bTo = tree.getOrDefault(b, new HashSet<>());
      bTo.add(a);
      tree.put(b, bTo);
    }

    int root;
    for (root = 0; root < n; root++) {
      if (tree.get(root).size() == 1) break;
    }

    TreeNode rootNode = construct(root, 0, tree, new HashSet<>());
    Map<Integer, TreeNode> nodes = new HashMap<>();
    int maxLevel = extractNodes(rootNode, nodes, 0);

    List<Set<TreeNode>> levels = new ArrayList<>(maxLevel + 1);
    for (int i = 0; i <= maxLevel; i++) {
      levels.add(new HashSet<>());
    }
    for (TreeNode node : nodes.values()) {
      levels.get(node.level).add(node);
    }
  }

  private static int extractNodes(TreeNode root, Map<Integer, TreeNode> nodes, int maxLevel) {
    if (root == null) return maxLevel;
    nodes.put(root.node, root);
    for (TreeNode child : root.children) {
      maxLevel = Math.max(maxLevel, extractNodes(child, nodes, root.level));
    }
    return maxLevel;
  }

  private static List<Set<TreeNode>> findDepth3(TreeNode root) {
    List<Set<TreeNode>> ans = new ArrayList<>(4);
    Queue<TreeNode> nodes = new ArrayDeque<>();
    nodes.add(root);
    for (int i = 0; i <= 3; i++) {
      ans.add(new HashSet<>());
      Queue<TreeNode> nexts = new ArrayDeque<>();
      while (!nodes.isEmpty()){
        TreeNode node = nodes.remove();
        ans.get(i).add(node);
        nexts.addAll(node.children);
      }
      nodes = nexts;
    }
    return ans;
  }

  private static TreeNode construct(int root, int level, Map<Integer, Set<Integer>> tree, Set<Integer> visited) {
    TreeNode r = new TreeNode();
    r.node = root;
    r.level = level;
    visited.add(root);

    for (int c : tree.get(root)) {
      if (!visited.contains(c)) {
        r.children.add(construct(c, level + 1, tree, visited));
      }
    }
    return r;
  }

  private static long gcd(long m, long n) {
    if (m < n) {
      return gcd(n, m);
    }
    if (n == 0) {
      return m;
    }
    return gcd(n, m % n);
  }

  private static long lcm(long m, long n) {
    return m / gcd(m, n) * n;
  }

  private static class Modular {

    private final long mod;

    private Modular(long mod) {
      this.mod = mod;
    }

    private long inverse(long n) {
      return pow(n, mod - 2) % mod;
    }

    private long pow(long x, long n) {
      /*
      long ans = 1;
      while (n > 0) {
        if ((n & 1) == 1) {
          ans = ans * x % mod;
        }
        x = x * x % mod;
        n >>= 1;
      }
      return ans;
      */
      if (n == 0) {
        return 1;
      }
      return n % 2 == 0 ?
          pow(x * x % mod, n / 2) % mod :
          x % mod * pow(x, n - 1) % mod;
    }
  }

  private static class ModularNFixedCombination {

    private final Modular modular;
    private final long[] comb;
    private final long N;

    public ModularNFixedCombination(long N, int size, long mod) {
      this.modular = new Modular(mod);
      this.comb = new long[size + 1];
      this.N = N;

      comb[0] = 1;

      for (int i = 1; i <= size; i++) {
        comb[i] = ((comb[i - 1] * (N - (i - 1))) % mod * modular.inverse(i)) % mod;
      }
    }

    long combination(int n, int k) {
      if (n != N) {
        throw new IllegalStateException();
      }
      return comb[k];
    }

    long repeatedCombination(int n, int k) {
      return combination(n + k - 1, k);
    }
  }

  private static class ModularCombination {

    private final long fact[];
    private final long mod;
    private final Modular modular;

    public ModularCombination(int size, long mod) {
      this.fact = new long[size + 1];
      this.mod = mod;
      this.modular = new Modular(mod);

      this.fact[0] = 1;
      for (int i = 1; i <= size; i++) {
        fact[i] = (fact[i - 1] * i) % mod;
      }
    }

    private long factorial(int n) {
      return fact[n];
    }

    long combination(int n, int k) {
      return
          (
              (
                  (
                      factorial(n) * modular.inverse(factorial(n - k))
                  ) % mod
              ) * modular.inverse(factorial(k))
          ) % mod;
    }

    long repeatedCombination(int n, int k) {
      return combination(n + k - 1, k);
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
