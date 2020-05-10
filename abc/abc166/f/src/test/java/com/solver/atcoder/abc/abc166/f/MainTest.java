package com.solver.atcoder.abc.abc166.f;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 1 3 0\n"
        + "AB\n"
        + "AC";
    String expected = "Yes\n"
        + "A\n"
        + "C";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "3 1 0 0\n"
        + "AB\n"
        + "BC\n"
        + "AB";
    String expected = "No";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "8 6 9 1\n"
        + "AC\n"
        + "BC\n"
        + "AB\n"
        + "BC\n"
        + "AC\n"
        + "BC\n"
        + "AB\n"
        + "AB";
    String expected = "Yes\n"
        + "C\n"
        + "B\n"
        + "B\n"
        + "C\n"
        + "C\n"
        + "B\n"
        + "A\n"
        + "A";

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