package com.solver.atcoder.aoj.ALDS1_13.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2\n"
        + "2 2\n"
        + "5 3";
    String expected = "......Q.\n"
        + "Q.......\n"
        + "..Q.....\n"
        + ".......Q\n"
        + ".....Q..\n"
        + "...Q....\n"
        + ".Q......\n"
        + "....Q...";
    
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