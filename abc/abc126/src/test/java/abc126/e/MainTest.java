package abc126.e;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class MainTest {

  @Test
  public void test() {
    String input = "3 1\n"
        + "1 2 1";

    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "6 5\n"
        + "1 2 1\n"
        + "2 3 2\n"
        + "1 3 3\n"
        + "4 5 4\n"
        + "5 6 5";

    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

//  @Test
//  public void test3() {
//    String input = "100000 1\n"
//        + "1 100000 100";
//
//    String expected = "99999";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
//  }

  private String execute(String input) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    return os.toString().replace(System.lineSeparator(), "\n");
  }
}