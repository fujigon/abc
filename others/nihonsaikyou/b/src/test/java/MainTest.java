import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 2\n"
        + "2 1";
    String expected = "3";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "3 2\n"
        + "1 2 0";
    String expected = "7";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test4() {
    String input = "3 2\n"
        + "1 3 2";
    String expected = "5";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3 5\n"
        + "1 1 1";
    String expected = "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "10 998244353\n"
        + "10 9 8 7 5 6 3 4 2 1";
    String expected = "185297239";

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