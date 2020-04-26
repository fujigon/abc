package com.solver.atcoder.abc.abc163.c;

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
        + "1 1 2 2";
    String expected = "2\n"
        + "2\n"
        + "0\n"
        + "0\n"
        + "0";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "10\n"
        + "1 1 1 1 1 1 1 1 1";
    String expected = "9\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "0\n"
        + "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "7\n"
        + "1 2 3 4 5 6";
    String expected = "1\n"
        + "1\n"
        + "1\n"
        + "1\n"
        + "1\n"
        + "1\n"
        + "0";

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