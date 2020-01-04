package com.solver.atcoder.abc.abc149.f;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class MainTest {

  @Test
  public void test() {
    String input = "5 4 1\n"
        + "1 2\n"
        + "2 3\n"
        + "3 4\n"
        + "3 5";

    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "5 4 5\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "1 5";

    String expected = "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }


  @Test
  public void test3() {
    String input = "2 1 2\n"
        + "1 2";

    String expected = "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test4() {
    String input = "9 6 1\n"
        + "1 2\n"
        + "2 3\n"
        + "3 4\n"
        + "4 5\n"
        + "5 6\n"
        + "4 7\n"
        + "7 8\n"
        + "8 9";
        
    String expected = "5";

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