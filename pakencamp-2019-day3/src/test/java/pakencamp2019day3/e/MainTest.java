package pakencamp2019day3.e;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "1 10\n"
        + ".#..##...#\n"
        + "1\n"
        + "1 7 1";

    String expected = "3";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "6 5\n"
        + "#..#.\n"
        + "..#..\n"
        + "#.#..\n"
        + "..#..\n"
        + ".#..#\n"
        + ".#...\n"
        + "1\n"
        + "3 4 1";

    String expected = "12";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "8 8\n"
        + "....#...\n"
        + "..#.....\n"
        + "......#.\n"
        + "#.......\n"
        + "...#....\n"
        + ".#......\n"
        + ".....#..\n"
        + ".......#\n"
        + "6\n"
        + "4 5 1\n"
        + "1 6 2\n"
        + "2 5 2\n"
        + "7 1 2\n"
        + "4 6 3\n"
        + "6 3 3";

    String expected = "56\n"
        + "2\n"
        + "14\n"
        + "6\n"
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