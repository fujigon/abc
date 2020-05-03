package com.solver.atcoder.abc.abc165.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 4 3\n"
        + "1 3 3 100\n"
        + "1 2 2 10\n"
        + "2 3 2 10";
    String expected = "110";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "4 6 10\n"
        + "2 4 1 86568\n"
        + "1 4 0 90629\n"
        + "2 3 0 90310\n"
        + "3 4 1 29211\n"
        + "3 4 3 78537\n"
        + "3 4 2 8580\n"
        + "1 2 1 96263\n"
        + "1 4 2 2156\n"
        + "1 2 0 94325\n"
        + "1 4 3 94328";
    String expected = "357500";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "10 10 1\n"
        + "1 10 9 1";
    String expected = "1";

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