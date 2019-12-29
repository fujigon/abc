package abc131.d;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Task {
    long weight;
    long deadline;
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    long n = sc.nextLong();
    List<Task> tasks = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Task task = new Task();
      task.weight = sc.nextLong();
      task.deadline = sc.nextLong();
      tasks.add(task);
    }
    tasks.sort(Comparator.comparingLong(t -> t.deadline));

    long current = 0;
    for (int i = 0; i < n; i++) {
      Task task = tasks.get(i);
      current += task.weight;
      if (task.deadline < current) {
        os.println("No");
        return;
      }
    }
    os.println("Yes");
  }
}