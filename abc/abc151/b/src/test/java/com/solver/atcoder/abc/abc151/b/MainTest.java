package com.solver.atcoder.abc.abc151.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5 10 7\n"
        + "8 10 3 6";
    String expected = "8";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "4 100 60\n"
        + "100 100 100";
    String expected = "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "4 100 60\n"
        + "0 0 0";
    String expected = "-1";

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