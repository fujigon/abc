package abc148.d;

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
        + "2 1 2";
    String expected = "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3\n"
        + "2 2 2";
    String expected = "-1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "10\n"
        + "3 1 4 1 5 9 2 6 5 3";
    String expected = "7";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test4() {
    String input = "1\n"
        + "1";
    String expected = "0";

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