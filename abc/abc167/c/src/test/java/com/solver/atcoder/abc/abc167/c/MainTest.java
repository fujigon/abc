package com.solver.atcoder.abc.abc167.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 3 10\n"
        + "60 2 2 4\n"
        + "70 8 7 9\n"
        + "50 2 3 9";
    String expected = "120";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "3 3 10\n"
        + "100 3 1 4\n"
        + "100 1 5 9\n"
        + "100 2 6 5";
    String expected = "-1";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "8 5 22\n"
        + "100 3 7 5 3 1\n"
        + "164 4 5 2 7 8\n"
        + "334 7 2 7 2 9\n"
        + "234 4 7 2 8 2\n"
        + "541 5 4 3 3 6\n"
        + "235 4 8 6 9 7\n"
        + "394 3 6 1 6 2\n"
        + "872 8 4 3 7 2";
    String expected = "1067";

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