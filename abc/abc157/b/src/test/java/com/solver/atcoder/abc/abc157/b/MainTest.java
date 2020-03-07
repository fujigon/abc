package com.solver.atcoder.abc.abc157.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "84 97 66\n"
        + "79 89 11\n"
        + "61 59 7\n"
        + "7\n"
        + "89\n"
        + "7\n"
        + "87\n"
        + "79\n"
        + "24\n"
        + "84\n"
        + "30";
    String expected = "Yes";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "41 7 46\n"
        + "26 89 2\n"
        + "78 92 8\n"
        + "5\n"
        + "6\n"
        + "45\n"
        + "16\n"
        + "57\n"
        + "17";
    String expected = "No";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "60 88 34\n"
        + "92 41 43\n"
        + "65 73 48\n"
        + "10\n"
        + "60\n"
        + "43\n"
        + "88\n"
        + "11\n"
        + "48\n"
        + "73\n"
        + "65\n"
        + "41\n"
        + "92\n"
        + "34";
    String expected = "Yes";

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