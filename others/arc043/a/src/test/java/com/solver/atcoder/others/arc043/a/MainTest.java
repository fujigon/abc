package com.solver.atcoder.others.arc043.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5 2 4\n" +
            "2\n" +
            "4\n" +
            "6\n" +
            "8\n" +
            "10";
    String expected = "0.5 -1.0";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
//    String input = "13 29 31\n" +
//            "3\n" +
//            "1\n" +
//            "4\n" +
//            "1\n" +
//            "5\n" +
//            "9\n" +
//            "2\n" +
//            "6\n" +
//            "5\n" +
//            "3\n" +
//            "5\n" +
//            "8\n" +
//            "9";
//    String expected = "3.875 10.8173076";
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