package com.solver.atcoder.others.abc084.d;

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
        + "3 7";
    String expected = "2";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "4\n"
        + "13 13\n"
        + "7 11\n"
        + "7 11\n"
        + "2017 2017";
    String expected = "1\n"
        + "0\n"
        + "0\n"
        + "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "6\n"
        + "1 53\n"
        + "13 91\n"
        + "37 55\n"
        + "19 51\n"
        + "73 91\n"
        + "13 49";
    String expected = "4\n"
        + "4\n"
        + "1\n"
        + "1\n"
        + "1\n"
        + "2";

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