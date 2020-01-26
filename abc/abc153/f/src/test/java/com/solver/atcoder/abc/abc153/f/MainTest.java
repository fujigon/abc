package com.solver.atcoder.abc.abc153.f;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 3 2\n"
        + "1 2\n"
        + "5 4\n"
        + "9 2";
    String expected = "2";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "9 4 1\n"
        + "1 5\n"
        + "2 4\n"
        + "3 3\n"
        + "4 2\n"
        + "5 1\n"
        + "6 2\n"
        + "7 3\n"
        + "8 4\n"
        + "9 5";
    String expected = "5";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3 0 1\n"
        + "300000000 1000000000\n"
        + "100000000 1000000000\n"
        + "200000000 1000000000";
    String expected = "3000000000";

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