package com.solver.atcoder.abc.abc159.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5\n"
        + "1 1 2 1 2";
    String expected = "2\n"
        + "2\n"
        + "3\n"
        + "2\n"
        + "3";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "4\n"
        + "1 2 3 4";
    String expected = "0\n"
        + "0\n"
        + "0\n"
        + "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "5\n"
        + "3 3 3 3 3";
    String expected = "6\n"
        + "6\n"
        + "6\n"
        + "6\n"
        + "6";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "8\n"
        + "1 2 1 4 2 1 4 1";
    String expected = "5\n"
        + "7\n"
        + "5\n"
        + "7\n"
        + "7\n"
        + "5\n"
        + "7\n"
        + "5";

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