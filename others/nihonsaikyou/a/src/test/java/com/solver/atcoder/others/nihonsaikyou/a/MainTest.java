package com.solver.atcoder.others.nihonsaikyou.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "15 40";
    String expected = "10";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test02() {
    String input = "12 31";
    String expected = "5";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test03() {
    String input = "1 1";
    String expected = "0";

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