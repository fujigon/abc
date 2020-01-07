package com.solver.atcoder.others.arc003.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "5\n"
        + "chokudai\n"
        + "kensho\n"
        + "imos\n"
        + "yuichirw\n"
        + "ao";
    String expected = "chokudai\n"
        + "ao\n"
        + "kensho\n"
        + "imos\n"
        + "yuichirw";
    
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