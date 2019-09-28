package abc142.c;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "6 3 4\n"
        + "3\n"
        + "1\n"
        + "3\n"
        + "2";
    String expected = "No\n"
        + "No\n"
        + "Yes\n"
        + "No\n"
        + "No\n"
        + "No";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "6 5 4\n"
        + "3\n"
        + "1\n"
        + "3\n"
        + "2";
    String expected = "Yes\n"
        + "Yes\n"
        + "Yes\n"
        + "Yes\n"
        + "Yes\n"
        + "Yes";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "10 13 15\n"
        + "3\n"
        + "1\n"
        + "4\n"
        + "1\n"
        + "5\n"
        + "9\n"
        + "2\n"
        + "6\n"
        + "5\n"
        + "3\n"
        + "5\n"
        + "8\n"
        + "9\n"
        + "7\n"
        + "9";
    String expected = "No\n"
        + "No\n"
        + "No\n"
        + "No\n"
        + "Yes\n"
        + "No\n"
        + "No\n"
        + "No\n"
        + "Yes\n"
        + "No";

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