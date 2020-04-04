package com.solver.atcoder.abc.abc160.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5 2 4";
    String expected = "5\n" +
            "4\n" +
            "1\n" +
            "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "3 1 3";
    String expected = "3\n" +
            "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "7 3 7";
    String expected = "7\n" +
            "8\n" +
            "4\n" +
            "2\n" +
            "0\n" +
            "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "10 4 8";
    String expected = "10\n" +
            "12\n" +
            "10\n" +
            "8\n" +
            "4\n" +
            "1\n" +
            "0\n" +
            "0\n" +
            "0";

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