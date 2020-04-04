package com.solver.atcoder.abc.abc160.f;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n" +
            "1 2\n" +
            "1 3";
    String expected = "2\n" +
            "1\n" +
            "1";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "2\n" +
            "1 2";
    String expected = "1\n" +
            "1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "5\n" +
            "1 2\n" +
            "2 3\n" +
            "3 4\n" +
            "3 5";
    String expected = "2\n" +
            "8\n" +
            "12\n" +
            "3\n" +
            "3";

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