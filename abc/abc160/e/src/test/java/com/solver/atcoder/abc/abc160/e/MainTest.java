package com.solver.atcoder.abc.abc160.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "1 2 2 2 1\n" +
            "2 4\n" +
            "5 1\n" +
            "3";
    String expected = "12";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "2 2 2 2 2\n" +
            "8 6\n" +
            "9 1\n" +
            "2 1";
    String expected = "25";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "2 2 4 4 4\n" +
            "11 12 13 14\n" +
            "21 22 23 24\n" +
            "1 2 3 4";
    String expected = "74";

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