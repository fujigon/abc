package pakencamp2019day3.d;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "1\n"
        + "B\n"
        + "R\n"
        + "#\n"
        + "W\n"
        + "B";
    String expected = "3";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3\n"
        + "WWR\n"
        + "#RW\n"
        + "BW#\n"
        + "##B\n"
        + "RBR";
    String expected = "10";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "8\n"
        + "RRRRRRRR\n"
        + "########\n"
        + "BBBBBBBB\n"
        + "RRRRRRRR\n"
        + "WWWWWWWW";
    String expected = "28";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test4() {
    String input = "7\n"
        + "BR#WB#R\n"
        + "RWW#WRB\n"
        + "##WBR#W\n"
        + "WB#B#RW\n"
        + "BRW##BB";
    String expected = "21";

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