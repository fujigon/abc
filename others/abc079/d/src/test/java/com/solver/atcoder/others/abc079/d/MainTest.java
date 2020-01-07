package com.solver.atcoder.others.abc079.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 4\n"
        + "0 9 9 9 9 9 9 9 9 9\n"
        + "9 0 9 9 9 9 9 9 9 9\n"
        + "9 9 0 9 9 9 9 9 9 9\n"
        + "9 9 9 0 9 9 9 9 9 9\n"
        + "9 9 9 9 0 9 9 9 9 2\n"
        + "9 9 9 9 9 0 9 9 9 9\n"
        + "9 9 9 9 9 9 0 9 9 9\n"
        + "9 9 9 9 9 9 9 0 9 9\n"
        + "9 9 9 9 2 9 9 9 0 9\n"
        + "9 2 9 9 9 9 9 9 9 0\n"
        + "-1 -1 -1 -1\n"
        + "8 1 1 8";
    String expected = "12";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "5 5\n"
        + "0 999 999 999 999 999 999 999 999 999\n"
        + "999 0 999 999 999 999 999 999 999 999\n"
        + "999 999 0 999 999 999 999 999 999 999\n"
        + "999 999 999 0 999 999 999 999 999 999\n"
        + "999 999 999 999 0 999 999 999 999 999\n"
        + "999 999 999 999 999 0 999 999 999 999\n"
        + "999 999 999 999 999 999 0 999 999 999\n"
        + "999 999 999 999 999 999 999 0 999 999\n"
        + "999 999 999 999 999 999 999 999 0 999\n"
        + "999 999 999 999 999 999 999 999 999 0\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1";
    String expected = "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3 5\n"
        + "0 4 3 6 2 7 2 5 3 3\n"
        + "4 0 5 3 7 5 3 7 2 7\n"
        + "5 7 0 7 2 9 3 2 9 1\n"
        + "3 6 2 0 2 4 6 4 2 3\n"
        + "3 5 7 4 0 6 9 7 6 7\n"
        + "9 8 5 2 2 0 4 7 6 5\n"
        + "5 4 6 3 2 3 0 5 4 3\n"
        + "3 6 2 3 4 2 4 0 8 9\n"
        + "4 6 5 4 3 5 3 2 0 8\n"
        + "2 1 3 4 5 7 8 6 4 0\n"
        + "3 5 2 6 1\n"
        + "2 5 3 2 1\n"
        + "6 9 2 5 6";
    String expected = "47";

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