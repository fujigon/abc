package com.solver.atcoder.others.abc085.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "1 10\n"
        + "3 5";
    String expected = "3";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "2 10\n"
        + "3 5\n"
        + "2 6";
    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "4 1000000000\n"
        + "1 1\n"
        + "1 10000000\n"
        + "1 30000000\n"
        + "1 99999999";
    String expected = "860000004";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "5 500\n"
        + "35 44\n"
        + "28 83\n"
        + "46 62\n"
        + "31 79\n"
        + "40 43";
    String expected = "9";

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