package com.solver.atcoder.others.joi2009ho.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "8\n"
        + "3\n"
        + "2\n"
        + "3\n"
        + "1\n"
        + "4\n"
        + "6\n";
    String expected = "3";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "20\n"
        + "4\n"
        + "4\n"
        + "12\n"
        + "8\n"
        + "16\n"
        + "7\n"
        + "7\n"
        + "11\n"
        + "8";
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