package nihonsaikyou.e;

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
        + "8 20";

    String expected = "7";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "2 10\n"
        + "3 5";

    String expected = "8";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "4 5\n"
        + "10 1 2 22";

    String expected = "7";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test4() {
    String input = "8 7\n"
        + "1 7 5 6 8 2 6 5";

    String expected = "5";

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