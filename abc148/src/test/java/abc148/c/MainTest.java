package abc148.c;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "123 456";
    String expected = "18696";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "100000 99999";
    String expected = "9999900000";

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