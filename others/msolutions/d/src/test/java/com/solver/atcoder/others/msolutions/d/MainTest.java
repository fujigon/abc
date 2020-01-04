package com.solver.atcoder.others.msolutions.d;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
//    String input = "5\n"
//        + "1 2\n"
//        + "2 3\n"
//        + "3 4\n"
//        + "4 5\n"
//        + "1 2 3 4 5";
//
//    String expected = "10";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
//    String input = "5\n"
//        + "1 2\n"
//        + "1 3\n"
//        + "1 4\n"
//        + "1 5\n"
//        + "3141 59 26 53 59";
//
//    String expected = "197\n"
//        + "59 26 3141 59 53";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
//    String input = "6 3\n"
//        + "-6 -100 50 -2 -5 -3";
//
//    String expected = "0";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  private String execute(String input) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    return os.toString().replace(System.lineSeparator(), "\n");
  }
}