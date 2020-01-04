package agc.agc034.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
//    String input = "7 1 3 6 7\n"
//        + ".#..#..";
//    String expected = "Yes";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
//    String input = "7 1 3 7 6\n"
//        + ".#..#..";
//    String expected = "No";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
//    String input = "15 1 3 15 13\n"
//        + "...#.#...#.#...";
//    String expected = "Yes";
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