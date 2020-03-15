package com.solver.atcoder.others.abc002.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5 3\n"
        + "1 2\n"
        + "2 3\n"
        + "1 3\n";
    String expected = "3";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "5 3\n"
        + "1 2\n"
        + "2 3\n"
        + "3 4";
    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "7 9\n"
        + "1 2\n"
        + "1 3\n"
        + "2 3\n"
        + "4 5\n"
        + "4 6\n"
        + "4 7\n"
        + "5 6\n"
        + "5 7\n"
        + "6 7";
    String expected = "4";

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