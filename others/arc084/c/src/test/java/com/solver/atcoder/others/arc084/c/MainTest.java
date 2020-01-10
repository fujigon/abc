package com.solver.atcoder.others.arc084.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2\n"
        + "1 5\n"
        + "2 4\n"
        + "3 6";
    String expected = "3";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "3\n"
        + "1 1 1\n"
        + "2 2 2\n"
        + "3 3 3";
    String expected = "27";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "6\n"
        + "3 14 159 2 6 53\n"
        + "58 9 79 323 84 6\n"
        + "2643 383 2 79 50 288";
    String expected = "87";

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