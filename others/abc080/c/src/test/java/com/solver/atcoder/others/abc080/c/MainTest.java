package com.solver.atcoder.others.abc080.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "1\n"
        + "1 1 0 1 0 0 0 1 0 1\n"
        + "3 4 5 6 7 8 9 -2 -3 4 -2";
    String expected = "8";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "2\n"
        + "1 1 1 1 1 0 0 0 0 0\n"
        + "0 0 0 0 0 1 1 1 1 1\n"
        + "0 -2 -2 -2 -2 -2 -1 -1 -1 -1 -1\n"
        + "0 -2 -2 -2 -2 -2 -1 -1 -1 -1 -1";
    String expected = "-2";

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