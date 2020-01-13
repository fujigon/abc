package com.solver.atcoder.others.codefestival2017qA.c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 4\n"
        + "aabb\n"
        + "aabb\n"
        + "aacc";
    String expected = "Yes";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }


  @Test
  public void test1() {
    String input = "5 1\n"
        + "t\n"
        + "w\n"
        + "e\n"
        + "e\n"
        + "t";
    String expected = "Yes";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "2 5\n"
        + "abxba\n"
        + "abyba";
    String expected = "No";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "1 1\n"
        + "z";
    String expected = "Yes";

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