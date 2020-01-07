package com.solver.atcoder.others.abc084.c;

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
            "6 5 1\n" +
            "1 10 1";
    String expected = "12\n" +
            "11\n" +
            "0";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "4\n" +
            "12 24 6\n" +
            "52 16 4\n" +
            "99 2 2";
    String expected = "187\n" +
            "167\n" +
            "101\n" +
            "0";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "4\n" +
            "12 13 1\n" +
            "44 17 17\n" +
            "66 4096 64";
    String expected = "4162\n" +
            "4162\n" +
            "4162\n" +
            "0";

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