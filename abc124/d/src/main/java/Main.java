import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();

    boolean[] sbool = new boolean[n];
    for (int i = 0; i < n; i++) {
      sbool[i] = s.charAt(i) == '1';
    }

    /* logic */
    int start = 0;

    List<StartEndPair> blocks = new ArrayList<>();

    // TODO clean up the loop
    for (int i = 0; i < n - 1; i++) {
      if (sbool[i] != sbool[i + 1]) {
        StartEndPair pair = new StartEndPair();
        pair.start = start;
        pair.end = i;
        pair.handstanding = sbool[i];
        blocks.add(pair);
        start = i + 1;
      }
    }

    // index last (n-1)
    StartEndPair pair = new StartEndPair();
    pair.start = start;
    pair.end = n - 1;
    pair.handstanding = sbool[n - 1];
    blocks.add(pair);

    List<Integer> list = new ArrayList();
    searchCandidate(blocks, k, list);
    list.sort(Integer::compareTo);
    os.println(list.get(list.size() - 1));
  }

  private static void searchCandidate(List<StartEndPair> blocks, int remaining,
      List<Integer> answer) {

    if (remaining == 0) {
      int longest = 0;
      for (int i = 0; i < blocks.size(); i++) {
        if (blocks.get(i).handstanding) {
          int length = blocks.get(i).end - blocks.get(i).start + 1;
          if (length > longest) {
            longest = length;
          }
        }
      }
      answer.add(longest);
      return;
    }

    // search longest block
    // TODO same size duplicated
    List<Integer> longestBlockIndexes = new ArrayList<>();
    longestBlockIndexes.add(0);
    int longestBlockLength = 0;
    for (int i = 0; i < blocks.size(); i++) {
      if (!blocks.get(i).handstanding) {
        int length = 0;
        if (i > 0) {
          int llength = blocks.get(i - 1).end - blocks.get(i - 1).start;
          length += llength;
        }
        int mlength = blocks.get(i).end - blocks.get(i).start;
        length += mlength;
        if (i < blocks.size() - 1) {
          int rlength = blocks.get(i + 1).end - blocks.get(i + 1).start;
          length += rlength;
        }
        if (length > longestBlockLength) {
          longestBlockIndexes.clear();
        }
        if (length >= longestBlockLength) {
          longestBlockIndexes.add(i);
          longestBlockLength = length;
        }
      }
    }

    for (int i = 0 ; i < longestBlockIndexes.size(); i++) {

      int longestBlockIndex = longestBlockIndexes.get(i);

      // merge
      StartEndPair m = blocks.get(longestBlockIndex);
      if (longestBlockIndex > 0) {
        StartEndPair l = blocks.get(longestBlockIndex - 1);
        m.start = l.start;
        blocks.remove(l);
      }
      if (longestBlockIndex < blocks.size() - 1) {
        StartEndPair r = blocks.get(longestBlockIndex + 1);
        m.end = r.end;
        blocks.remove(r);
      }
      m.handstanding = true;

      searchCandidate(blocks, remaining - 1, answer);

    }
  }


  private static class StartEndPair {

    boolean handstanding;

    int start;
    int end;

    @Override
    public String toString() {
      return "StartEndPair{" +
          "handstanding=" + handstanding +
          ", start=" + start +
          ", end=" + end +
          '}';
    }
  }

}