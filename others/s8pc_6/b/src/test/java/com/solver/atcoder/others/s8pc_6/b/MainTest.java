package com.solver.atcoder.others.s8pc_6.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n"
        + "5 7\n"
        + "2 6\n"
        + "8 10";
    String expected = "18";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "5\n"
        + "1 71\n"
        + "43 64\n"
        + "13 35\n"
        + "14 54\n"
        + "79 85";
    String expected = "334";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "11\n"
        + "15004200 341668840\n"
        + "277786703 825590503\n"
        + "85505967 410375631\n"
        + "797368845 930277710\n"
        + "90107929 763195990\n"
        + "104844373 888031128\n"
        + "338351523 715240891\n"
        + "458782074 493862093\n"
        + "189601059 534714600\n"
        + "299073643 971113974\n"
        + "98291394 443377420";
    String expected = "8494550716";

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