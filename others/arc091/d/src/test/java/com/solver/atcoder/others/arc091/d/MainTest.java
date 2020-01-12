package com.solver.atcoder.others.arc091.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5 2";
    String expected = "7";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "10 0";
    String expected = "100";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "31415 9265";
    String expected = "287927211";

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