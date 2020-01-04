package com.solver.atcoder.others.diverta2019.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test0() {
    String input = "1\n"
        + "1 1";
    String expected = "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test() {
    String input = "2\n"
        + "1 1\n"
        + "2 2";
    String expected = "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

//  @Test
//  public void test2() {
//    String input = "3\n"
//        + "1 4\n"
//        + "4 6\n"
//        + "7 8";
//    String expected = "1";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
//  }

  @Test
  public void test2() {
    String input = "3\n"
        + "7 8\n"
        + "4 6\n"
        + "1 4";
    String expected = "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "4\n"
        + "1 1\n"
        + "1 2\n"
        + "2 1\n"
        + "2 2";
    String expected = "2";

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