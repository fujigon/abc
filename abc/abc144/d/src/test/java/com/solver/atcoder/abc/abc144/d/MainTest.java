package com.solver.atcoder.abc.abc144.d;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
//    String input = "2 2 4";
//    String expected = "45.0000000000";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
//    String input = "12 21 10";
//    String expected = "89.7834636934";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
//    String input = "3 1 8";
//    String expected = "4.2363947991";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
  }
  
  private String execute(String input) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    return os.toString().replace(System.lineSeparator(), "\n");
  }
}