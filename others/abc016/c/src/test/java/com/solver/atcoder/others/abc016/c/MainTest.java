package com.solver.atcoder.others.abc016.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 2\n"
        + "1 2\n"
        + "2 3\n";
    String expected = "1\n"
        + "0\n"
        + "1";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "3 3\n"
        + "1 2\n"
        + "1 3\n"
        + "2 3\n";
    String expected = "0\n"
        + "0\n"
        + "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "8 12\n"
        + "1 6\n"
        + "1 7\n"
        + "1 8\n"
        + "2 5\n"
        + "2 6\n"
        + "3 5\n"
        + "3 6\n"
        + "4 5\n"
        + "4 8\n"
        + "5 6\n"
        + "5 7\n"
        + "7 8\n";
    String expected = "4\n"
        + "4\n"
        + "4\n"
        + "5\n"
        + "2\n"
        + "3\n"
        + "4\n"
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