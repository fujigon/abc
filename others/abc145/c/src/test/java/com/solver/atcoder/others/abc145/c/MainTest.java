package com.solver.atcoder.others.abc145.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n"
        + "0 0\n"
        + "1 0\n"
        + "0 1";
    String expected = "2.2761423749";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "8\n"
        + "-406 10\n"
        + "512 859\n"
        + "494 362\n"
        + "-955 -475\n"
        + "128 553\n"
        + "-986 -885\n"
        + "763 77\n"
        + "449 310";
    String expected = "7641.9817824387";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "2\n"
        + "-879 981\n"
        + "-866 890";
    String expected = "91.9238815543";

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