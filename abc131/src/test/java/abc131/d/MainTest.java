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
    String input = "5\n"
        + "2 4\n"
        + "1 9\n"
        + "1 8\n"
        + "4 9\n"
        + "3 12";

    String expected = "Yes";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3\n"
        + "334 1000\n"
        + "334 1000\n"
        + "334 1000";

    String expected = "No";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "30\n"
        + "384 8895\n"
        + "1725 9791\n"
        + "170 1024\n"
        + "4 11105\n"
        + "2 6\n"
        + "578 1815\n"
        + "702 3352\n"
        + "143 5141\n"
        + "1420 6980\n"
        + "24 1602\n"
        + "849 999\n"
        + "76 7586\n"
        + "85 5570\n"
        + "444 4991\n"
        + "719 11090\n"
        + "470 10708\n"
        + "1137 4547\n"
        + "455 9003\n"
        + "110 9901\n"
        + "15 8578\n"
        + "368 3692\n"
        + "104 1286\n"
        + "3 4\n"
        + "366 12143\n"
        + "7 6649\n"
        + "610 2374\n"
        + "152 7324\n"
        + "4 7042\n"
        + "292 11386\n"
        + "334 5720";

    String expected = "Yes";

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