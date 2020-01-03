package solver;

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
    String s = sc.next();

    boolean[] sbool = new boolean[n];
    for (int i = 0; i < n; i++) {
      sbool[i] = s.charAt(i) == '1';
    }

    /* logic */
    List<Block> blocks = partitioning(sbool);
    int longest = searchLongestMergedBlocks(blocks, k);
    os.println(longest);
  }

  private static List<Block> partitioning(boolean[] sbool) {

    List<Block> blocks = new ArrayList<>();

    int right = 0;
    for (int left = 0; left < sbool.length; left++) {

      while (right < sbool.length && (sbool[left] == sbool[right])) {
        right++;
      }

      // found the block. if the longest block, let's save
      if (blocks.isEmpty() || ((blocks.get(blocks.size() - 1).end) != right)) {
        Block block = new Block();
        block.start = left;
        block.end = right;
        block.handstanding = sbool[left];
        blocks.add(block);
      }
    }
    return blocks;
  }

  private static int searchLongestMergedBlocks(List<Block> blocks, int remaining) {

    int longest = 0;
    // search the every reversed result starting i-indexed block
    for (int i = 0; i < blocks.size(); i++) {
      Block start = blocks.get(i);

      int mergingBlocks = start.handstanding ? 2 * remaining : 2 * remaining - 1;
      int endIndex = Math.min(Math.max(mergingBlocks, 0) + i, blocks.size() - 1);
      Block end = blocks.get(endIndex);

      int length = end.end - start.start;

      if (length > longest) {
        longest = length;
      }
    }

    return longest;
  }


  private static class Block {

    boolean handstanding;

    // half-open interval
    int start;
    int end;

    @Override
    public String toString() {
      return "Block{" +
          "handstanding=" + handstanding +
          ", start=" + start +
          ", end=" + end +
          '}';
    }
  }

}