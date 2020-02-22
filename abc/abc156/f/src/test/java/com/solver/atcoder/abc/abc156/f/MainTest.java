package com.solver.atcoder.abc.abc156.f;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 1\n"
        + "3 1 4\n"
        + "5 3 2";
    String expected = "1";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "7 3\n"
        + "27 18 28 18 28 46 1000000000\n"
        + "1000000000 1 7\n"
        + "1000000000 2 10\n"
        + "1000000000 3 12";
    String expected = "224489796\n"
        + "214285714\n"
        + "559523809";

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