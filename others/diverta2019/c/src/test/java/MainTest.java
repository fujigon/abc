import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
//    String input = "3\n"
//        + "1 -1 2";
//    String expected = "4\n"
//        + "-1 1\n"
//        + "2 -2";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
//    String input = "3\n"
//        + "1 1 1";
//    String expected = "1\n"
//        + "1 1\n"
//        + "1 0";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
//    String input = "100 5\n"
//        + "1\n"
//        + "23\n"
//        + "45\n"
//        + "67\n"
//        + "89";
//    String expected = "608200469";
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