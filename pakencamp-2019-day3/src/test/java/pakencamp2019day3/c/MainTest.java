package pakencamp2019day3.c;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "1 2\n"
        + "80 84";
    String expected = "84";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "3 4\n"
        + "37 29 70 41\n"
        + "85 69 76 50\n"
        + "53 10 95 100";
    String expected = "250";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

//  @Test
//  public void test2() {
//    String input = "10 4\n"
//        + "2 0 1 3 7 5 4 6 8 9";
//    String expected = "6";
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