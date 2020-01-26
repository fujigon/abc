package com.solver.atcoder.abc.abc153.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "9 3\n"
        + "8 3\n"
        + "4 2\n"
        + "2 1";
    String expected = "4";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "100 6\n"
        + "1 1\n"
        + "2 3\n"
        + "3 9\n"
        + "4 27\n"
        + "5 81\n"
        + "6 243";
    String expected = "100";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "9999 10\n"
        + "540 7550\n"
        + "691 9680\n"
        + "700 9790\n"
        + "510 7150\n"
        + "415 5818\n"
        + "551 7712\n"
        + "587 8227\n"
        + "619 8671\n"
        + "588 8228\n"
        + "176 2461";
    String expected = "139815";

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