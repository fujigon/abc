import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n"
        + "2 2 4";

    String expected = "4 0 4";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "5\n"
        + "3 8 7 5 5";

    String expected = "2 4 12 2 8";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "3\n"
        + "1000000000 1000000000 0";

    String expected = "0 2000000000 0";

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