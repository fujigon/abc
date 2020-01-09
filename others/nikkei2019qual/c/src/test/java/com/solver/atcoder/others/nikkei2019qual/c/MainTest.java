package com.solver.atcoder.others.nikkei2019qual.c;

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
        + "10 10\n"
        + "20 20\n"
        + "30 30";
    String expected = "20";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3\n"
        + "20 10\n"
        + "20 20\n"
        + "20 30";
    String expected = "20";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "6\n"
        + "1 1000000000\n"
        + "1 1000000000\n"
        + "1 1000000000\n"
        + "1 1000000000\n"
        + "1 1000000000\n"
        + "1 1000000000";
    String expected = "-2999999997";

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