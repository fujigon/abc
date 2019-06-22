package abc131.d;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "4 10\n"
        + "6 1 2 7";

    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "10 53462\n"
        + "103 35322 232 342 21099 90000 18843 9010 35221 19352";

    String expected = "36";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "4 1\n"
        + "100 100 100 100";

    String expected = "10";

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