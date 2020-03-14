package com.solver.atcoder.others.hitachi2020.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 3 1\n"
        + "3 3\n"
        + "3 3 3\n"
        + "1 2 1";
    String expected = "5";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "1 1 2\n"
        + "10\n"
        + "10\n"
        + "1 1 5\n"
        + "1 1 10";
    String expected = "10";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "2 2 1\n"
        + "3 5\n"
        + "3 5\n"
        + "2 2 2";
    String expected = "6";

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