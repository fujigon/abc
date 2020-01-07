package com.solver.atcoder.others.abc138.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.io.PrintWriter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "4 3\n" +
            "1 2\n" +
            "2 3\n" +
            "2 4\n" +
            "2 10\n" +
            "1 100\n" +
            "3 1";
    String expected = "100 110 111 110";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "6 2\n" +
            "1 2\n" +
            "1 3\n" +
            "2 4\n" +
            "3 6\n" +
            "2 5\n" +
            "1 10\n" +
            "1 10";
    String expected = "20 20 20 20 20 20";

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