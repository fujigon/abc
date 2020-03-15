package com.solver.atcoder.others.joi2007ho.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "10\n"
        + "9 4\n"
        + "4 3\n"
        + "1 1\n"
        + "4 2\n"
        + "2 4\n"
        + "5 8\n"
        + "4 0\n"
        + "5 3\n"
        + "0 5\n"
        + "5 2";
    String expected = "10";
    
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