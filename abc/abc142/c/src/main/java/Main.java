import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    solve(System.in, System.out);
  }

  private static class Student {

    int id;
    int order;
  }

  static void solve(InputStream is, PrintStream os) {
    Scanner sc = new Scanner(is);

    /* read */
    int n = sc.nextInt();

    List<Student> students = new ArrayList<>(n);

    for (int i = 1; i <= n; i++) {
      Student s = new Student();
      s.id = i;
      s.order = sc.nextInt();
      students.add(s);
    }

    students.sort(Comparator.comparingInt(s -> s.order));

    List<String> ids = students.stream().map(student -> String.valueOf(student.id))
        .collect(Collectors.toList());

    os.println(String.join(" ", ids));
  }

}