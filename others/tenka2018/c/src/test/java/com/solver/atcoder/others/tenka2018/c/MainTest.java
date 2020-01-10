package com.solver.atcoder.others.tenka2018.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5\n"
        + "6\n"
        + "8\n"
        + "1\n"
        + "2\n"
        + "3";
    String expected = "21";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "6\n"
        + "3\n"
        + "1\n"
        + "4\n"
        + "1\n"
        + "5\n"
        + "9";
    String expected = "25";

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