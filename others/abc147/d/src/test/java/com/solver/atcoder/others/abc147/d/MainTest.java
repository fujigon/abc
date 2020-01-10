package com.solver.atcoder.others.abc147.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n"
        + "1 2 3";
    String expected = "6";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "10\n"
        + "3 1 4 1 5 9 2 6 5 3";
    String expected = "237";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "10\n"
        + "3 14 159 2653 58979 323846 2643383 27950288 419716939 9375105820";
    String expected = "103715602";

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