package abc.abc142.e;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 3\n"
        + "10 1\n"
        + "1\n"
        + "15 1\n"
        + "2\n"
        + "30 2\n"
        + "1 2";

    String expected = "25";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "12 1\n"
        + "100000 1\n"
        + "2";

    String expected = "-1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "4 6\n"
        + "67786 3\n"
        + "1 3 4\n"
        + "3497 1\n"
        + "2\n"
        + "44908 3\n"
        + "2 3 4\n"
        + "2156 3\n"
        + "2 3 4\n"
        + "26230 1\n"
        + "2\n"
        + "86918 1\n"
        + "3";

    String expected = "69942";

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