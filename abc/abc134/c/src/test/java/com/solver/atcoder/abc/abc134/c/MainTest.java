package com.solver.atcoder.abc.abc134.c;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n"
        + "1\n"
        + "4\n"
        + "3";
    String expected = "4\n"
        + "3\n"
        + "4";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "2\n"
        + "5\n"
        + "5";
    String expected = "5\n"
        + "5";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "4\n"
        + "5\n"
        + "5\n"
        + "4\n"
        + "5";
    String expected = "5\n"
        + "5\n"
        + "5\n"
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