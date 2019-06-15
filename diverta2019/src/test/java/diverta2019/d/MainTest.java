package diverta2019.d;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
//    String input = "4 6\n"
//        + "#..#..\n"
//        + ".....#\n"
//        + "....#.\n"
//        + "#.#...";
//
//    String expected = "8";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
//    String input = "8 8\n"
//        + "..#...#.\n"
//        + "....#...\n"
//        + "##......\n"
//        + "..###..#\n"
//        + "...#..#.\n"
//        + "##....#.\n"
//        + "#...#...\n"
//        + "###.#..#";
//
//    String expected = "13";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
//    String input = "6 3\n"
//        + "-6 -100 50 -2 -5 -3";
//
//    String expected = "0";
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