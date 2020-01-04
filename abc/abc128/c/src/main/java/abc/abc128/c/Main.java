package abc.abc128.c;

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
    int m = sc.nextInt();

    Map<Integer, Set<Integer>> checkingSwitches = new HashMap<>();
    int[] checkingSwitchCondition = new int[m + 1];

    for (int i = 0; i < m; i++) {
      int switchNum = sc.nextInt();
      Set<Integer> checkingSwitch = new HashSet<>();
      for (int j = 0; j < switchNum; j++) {
        checkingSwitch.add(sc.nextInt());
      }
      checkingSwitches.put(i + 1, checkingSwitch);
    }

    for (int i = 0; i < m; i++) {
      checkingSwitchCondition[i + 1] = sc.nextInt();
    }

    boolean[] on = new boolean[n + 1];
    on[1] = true;
    int result = 0;
    result += check(1, n, on, checkingSwitches, checkingSwitchCondition);
    on[1] = false;
    result += check(1, n, on, checkingSwitches, checkingSwitchCondition);

    os.println(result);
  }

  private static int check(int switchIndex, int totalSwitchNum, boolean[] on,
      Map<Integer, Set<Integer>> checkingSwitches, int[] checkingSwitchCondition) {
    if (switchIndex == totalSwitchNum) {
      for (int lampIndex : checkingSwitches.keySet()) {
        int onCount = 0;
        for (int checkingSwitchIndex : checkingSwitches.get(lampIndex)) {
          if (on[checkingSwitchIndex]) {
            onCount++;
          }
        }
        if (onCount % 2 != checkingSwitchCondition[lampIndex]) {
          return 0;
        }
      }
      return 1;
    }
    int total = 0;
    on[switchIndex + 1] = true;
    total += check(switchIndex + 1, totalSwitchNum, on, checkingSwitches, checkingSwitchCondition);
    on[switchIndex + 1] = false;
    total += check(switchIndex + 1, totalSwitchNum, on, checkingSwitches, checkingSwitchCondition);
    return total;
  }
}