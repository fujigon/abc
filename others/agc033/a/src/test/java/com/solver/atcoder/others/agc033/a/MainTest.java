package com.solver.atcoder.others.agc033.a;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 3\n"
        + "...\n"
        + ".#.\n"
        + "...";
    String expected = "2";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "6 6\n"
        + "..#..#\n"
        + "......\n"
        + "#..#..\n"
        + "......\n"
        + ".#....\n"
        + "....#.";
    String expected = "3";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() throws IOException {
    String input = Resources.toString(Resources.getResource("in01.txt"), Charsets.UTF_8);
    String expected = "9";

    while (true) {
      assertThat(execute(input + "\n"), is(expected + "\n"));
      System.out.println("for debug");
    }
  }

  @Test
  public void test3() throws IOException {
    String input = Resources.toString(Resources.getResource("in04.txt"), Charsets.UTF_8);
    String expected = "0";

    while (true) {
      assertThat(execute(input + "\n"), is(expected + "\n"));
      System.out.println("for debug");
    }
  }

  @Test
  public void test4() throws IOException {
    String input = Resources.toString(Resources.getResource("in03.txt"), Charsets.UTF_8);
    String expected = "2";

    while (true) {
      assertThat(execute(input + "\n"), is(expected + "\n"));
      System.out.println("for debug");
    }
  }

  private String execute(String input) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    return os.toString().replace(System.lineSeparator(), "\n");
  }

}