import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 2\n"
        + "5 1 4\n"
        + "2 3\n"
        + "1 5";

    String expected = "14";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "10 3\n"
        + "1 8 5 7 100 4 52 33 13 5\n"
        + "3 10\n"
        + "4 30\n"
        + "1 4";

    String expected = "338";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "11 3\n"
        + "1 1 1 1 1 1 1 1 1 1 1\n"
        + "3 1000000000\n"
        + "4 1000000000\n"
        + "3 1000000000";

    String expected = "10000000001";

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