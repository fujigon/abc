package abc143.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "4";
    String expected = "0.5000000000";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test02() {
    String input = "5";
    String expected = "0.6000000000";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test03() {
    String input = "1";
    String expected = "1.0000000000";

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