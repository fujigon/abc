package com.solver.atcoder.abc.abc157.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "4 4 1\n"
        + "2 1\n"
        + "1 3\n"
        + "3 2\n"
        + "3 4\n"
        + "4 1";
    String expected = "0 1 0 1";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "5 10 0\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "1 5\n"
        + "3 2\n"
        + "2 4\n"
        + "2 5\n"
        + "4 3\n"
        + "5 3\n"
        + "4 5";
    String expected = "0 0 0 0 0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "10 9 3\n"
        + "10 1\n"
        + "6 7\n"
        + "8 2\n"
        + "2 5\n"
        + "8 4\n"
        + "7 3\n"
        + "10 9\n"
        + "6 4\n"
        + "5 8\n"
        + "2 6\n"
        + "7 5\n"
        + "3 1";
    String expected = "1 3 5 4 3 3 3 3 1 0";

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