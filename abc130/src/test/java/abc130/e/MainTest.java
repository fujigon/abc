package abc130.e;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class MainTest {

  @Test
  public void test() {
    String input = "2 2\n"
        + "1 3\n"
        + "3 1";

    String expected = "3";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "2 2\n"
        + "1 1\n"
        + "1 1";

    String expected = "6";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "20 20\n"
        + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n"
        + "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";

    String expected = "846527861";

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