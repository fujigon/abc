package abc143.e;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 2 5\n" +
            "1 2 3\n" +
            "2 3 3\n" +
            "2\n" +
            "3 2\n" +
            "1 3";

    String expected = "0\n" +
            "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "4 0 1\n" +
            "1\n" +
            "2 1";

    String expected = "-1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "5 4 4\n" +
            "1 2 2\n" +
            "2 3 2\n" +
            "3 4 3\n" +
            "4 5 2\n" +
            "20\n" +
            "2 1\n" +
            "3 1\n" +
            "4 1\n" +
            "5 1\n" +
            "1 2\n" +
            "3 2\n" +
            "4 2\n" +
            "5 2\n" +
            "1 3\n" +
            "2 3\n" +
            "4 3\n" +
            "5 3\n" +
            "1 4\n" +
            "2 4\n" +
            "3 4\n" +
            "5 4\n" +
            "1 5\n" +
            "2 5\n" +
            "3 5\n" +
            "4 5";

    String expected = "0\n" +
            "0\n" +
            "1\n" +
            "2\n" +
            "0\n" +
            "0\n" +
            "1\n" +
            "2\n" +
            "0\n" +
            "0\n" +
            "0\n" +
            "1\n" +
            "1\n" +
            "1\n" +
            "0\n" +
            "0\n" +
            "2\n" +
            "2\n" +
            "1\n" +
            "0";

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