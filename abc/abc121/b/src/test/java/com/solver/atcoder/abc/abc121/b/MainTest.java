package com.solver.atcoder.abc.abc121.b;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test1() {
    String input = "2 3 -10\n"
        + "1 2 3\n"
        + "3 2 1\n"
        + "1 2 2";

    String expected = "1";

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