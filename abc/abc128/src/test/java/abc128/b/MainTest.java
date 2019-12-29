package abc128.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "6\n"
        + "khabarovsk 20\n"
        + "moscow 10\n"
        + "kazan 50\n"
        + "kazan 35\n"
        + "moscow 60\n"
        + "khabarovsk 40";
    String expected = "3\n"
        + "4\n"
        + "6\n"
        + "1\n"
        + "5\n"
        + "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "10\n"
        + "yakutsk 10\n"
        + "yakutsk 20\n"
        + "yakutsk 30\n"
        + "yakutsk 40\n"
        + "yakutsk 50\n"
        + "yakutsk 60\n"
        + "yakutsk 70\n"
        + "yakutsk 80\n"
        + "yakutsk 90\n"
        + "yakutsk 100";
    String expected = "10\n"
        + "9\n"
        + "8\n"
        + "7\n"
        + "6\n"
        + "5\n"
        + "4\n"
        + "3\n"
        + "2\n"
        + "1";

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