package abc127.d;

import abc127.d.Main;
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
        + "1 2 2\n"
        + "2 3 1";

    String expected = "0\n"
        + "0\n"
        + "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
//    String input = "5\n"
//        + "2 5 2\n"
//        + "2 3 10\n"
//        + "1 3 8\n"
//        + "3 4 2";
//
//    String expected = "1\n"
//        + "0\n"
//        + "1\n"
//        + "0\n"
//        + "1";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  private String execute(String input) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    return os.toString().replace(System.lineSeparator(), "\n");
  }
}