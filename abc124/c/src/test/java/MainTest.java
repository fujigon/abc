import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "";
    input += "5\n" +
        "3\n" +
        "2\n" +
        "4\n" +
        "3\n" +
        "5";
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    assertThat(os.toString(), is("7" + System.lineSeparator()));
  }

  @Test
  public void test2() {
    String input = "";
    input += "10\n" +
        "123\n" +
        "123\n" +
        "123\n" +
        "123\n" +
        "123";

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    assertThat(os.toString(), is("5"
        + System.lineSeparator()));
  }

  @Test
  public void test3() {
    String input = "";
    input += "10000000007\n" +
        "2\n" +
        "3\n" +
        "5\n" +
        "7\n" +
        "11";

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    assertThat(os.toString(), is("5000000008"
        + System.lineSeparator()));
  }

}