package others.diverta2019.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static int goldA;
  private static int silvA;
  private static int brnzA;
  private static int goldB;
  private static int silvB;
  private static int brnzB;

  private static class Asset {

    int acrn;
    int gold;
    int silv;
    int brnz;

    Asset() {
    }

    Asset(Asset copy) {
      this.acrn = copy.acrn;
      this.gold = copy.gold;
      this.silv = copy.silv;
      this.brnz = copy.brnz;
    }
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    int n = sc.nextInt();

    goldA = sc.nextInt();
    silvA = sc.nextInt();
    brnzA = sc.nextInt();

    goldB = sc.nextInt();
    silvB = sc.nextInt();
    brnzB = sc.nextInt();

    // convert all assets to money. value is measured by B market, weight is measured By A market
    int acornFirst = n;
    Asset first = convertToMoney(acornFirst, goldA, silvA, brnzA, Main::acornValAtB);

    // convert all assets to money. value is measured by A market, weight is measured By B market
    int acornSecond = acornValAtB(first);
    Asset second = convertToMoney(acornSecond, goldB, silvB, brnzB, Main::acornValAtA);

    os.println(acornValAtA(second));
  }

  // knapsack
  private static Asset convertToMoney(int acorn, int goldWeight, int silvWeight, int brnzWeight, Function<Asset, Integer> evaluator) {
    Asset[] dp = new Asset[acorn + 1];
    dp[0] = new Asset();

    Asset last = dp[0];
    int diffAcorn = acorn;
    for (int i = 0; i <= acorn; i++) {
      if(dp[i] == null) continue;

      last = dp[i];
      diffAcorn = acorn - i;

      // acorn
      knapsackHelper(dp, i, 1, a -> a.acrn++, evaluator);

      // gold
      knapsackHelper(dp, i, goldWeight, a -> a.gold++, evaluator);

      // silver
      knapsackHelper(dp, i, silvWeight, a -> a.silv++, evaluator);

      // bronze
      knapsackHelper(dp, i, brnzWeight, a -> a.brnz++, evaluator);

    }
    last = new Asset(last);
    last.acrn = diffAcorn;
    return dp[acorn];
  }

  private static void knapsackHelper(Asset[] dp, int index, int weight, Consumer<Asset> assetIncrement, Function<Asset, Integer> evaluator) {
    Asset current = dp[index];
    if (index + weight >= dp.length) {
      return;
    }
    Asset candidate = new Asset(current);
    assetIncrement.accept(candidate);
    if (dp[index + weight] == null) {
      dp[index + weight] = candidate;
      return;
    }

    int exst = evaluator.apply(dp[index + weight]);
    int cand = evaluator.apply(candidate);
    if (cand > exst) dp[index + weight] = candidate;
  }

  private static int acornValAtA(Asset asset) {
    return asset.acrn + asset.gold * goldA + asset.silv * silvA + asset.brnz * brnzA;
  }

  private static int acornValAtB(Asset asset) {
    return asset.acrn + asset.gold * goldB + asset.silv * silvB + asset.brnz * brnzB;
  }

}