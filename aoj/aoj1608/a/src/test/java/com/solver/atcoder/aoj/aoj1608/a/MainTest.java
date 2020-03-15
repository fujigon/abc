package com.solver.atcoder.aoj.aoj1608.a;

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
        + "10 10 10 10 10\n"
        + "5\n"
        + "1 5 8 9 11\n"
        + "7\n"
        + "11 34 83 47 59 29 70\n"
        + "0";
    String expected = "0\n"
        + "1\n"
        + "5";
    
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