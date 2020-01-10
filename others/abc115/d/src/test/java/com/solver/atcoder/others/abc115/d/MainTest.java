package com.solver.atcoder.others.abc115.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 7";
    String expected = "4";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "1 1";
    String expected = "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "50 4321098765432109";
    String expected = "2160549382716056";

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