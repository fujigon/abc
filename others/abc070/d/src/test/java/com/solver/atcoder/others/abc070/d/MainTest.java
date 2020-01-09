package com.solver.atcoder.others.abc070.d;

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
        + "1 2 1\n"
        + "1 3 1\n"
        + "2 4 1\n"
        + "3 5 1\n"
        + "3 1\n"
        + "2 4\n"
        + "2 3\n"
        + "4 5";
    String expected = "3\n"
        + "2\n"
        + "4";
    
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