package com.solver.atcoder.abc.abc131.e;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n"
        + "1 1\n"
        + "5 1\n"
        + "5 5";

    String expected = "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "2\n"
        + "10 10\n"
        + "20 20";

    String expected = "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "9\n"
        + "1 1\n"
        + "2 1\n"
        + "3 1\n"
        + "4 1\n"
        + "5 1\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "1 5";

    String expected = "16";

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