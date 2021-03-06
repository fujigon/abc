package com.solver.atcoder.abc.abc135.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 16";
    String expected = "9";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test02() {
    String input = "0 3";
    String expected = "IMPOSSIBLE";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test03() {
    String input = "998244353 99824435";
    String expected = "549034394";

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