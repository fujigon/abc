package com.solver.atcoder.abc.abc158.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "a\n"
        + "4\n"
        + "2 1 p\n"
        + "1\n"
        + "2 2 c\n"
        + "1";
    String expected = "cpa";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "a\n"
        + "6\n"
        + "2 2 a\n"
        + "2 1 b\n"
        + "1\n"
        + "2 2 c\n"
        + "1\n"
        + "1";
    String expected = "aabc";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "y\n"
        + "1\n"
        + "2 1 x";
    String expected = "xy";

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