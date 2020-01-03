package solver;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "4 3\n"
        + "1 2\n"
        + "2 3\n"
        + "3 4";

    String expected = "6";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "5 4\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "4 5";

    String expected = "48";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "16 22\n"
        + "12 1\n"
        + "3 1\n"
        + "4 16\n"
        + "7 12\n"
        + "6 2\n"
        + "2 15\n"
        + "5 16\n"
        + "14 16\n"
        + "10 11\n"
        + "3 10\n"
        + "3 13\n"
        + "8 6\n"
        + "16 8\n"
        + "9 12\n"
        + "4 3";

    String expected = "271414432";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  private String execute(String input) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    return os.toString().replace(System.lineSeparator(), "\n");
  }
}