package com.solver.atcoder.others.joi2008.d;

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
        + "8 5\n"
        + "6 4\n"
        + "4 3\n"
        + "7 10\n"
        + "0 10\n"
        + "10\n"
        + "10 5\n"
        + "2 7\n"
        + "9 7\n"
        + "8 10\n"
        + "10 2\n"
        + "1 2\n"
        + "8 1\n"
        + "6 7\n"
        + "6 0\n"
        + "0 9";
    String expected = "2 -3";
    
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