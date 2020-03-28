package com.solver.atcoder.abc.abc159.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test1() {
    String input = "3 5 4\n"
        + "11100\n"
        + "10001\n"
        + "00111";
    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "1 5 1\n"
        + "11100";
    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test() {
    String input = "3 5 8\n"
        + "11100\n"
        + "10001\n"
        + "00111";
    String expected = "0";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "4 10 4\n"
        + "1110010010\n"
        + "1000101110\n"
        + "0011101001\n"
        + "1101000111";
    String expected = "3";

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