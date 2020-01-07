package com.solver.atcoder.others.diverta2019.c;

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
            "ABCA\n" +
            "XBAZ\n" +
            "BAD";
    String expected = "2";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "9\n" +
            "BEWPVCRWH\n" +
            "ZZNQYIJX\n" +
            "BAVREA\n" +
            "PA\n" +
            "HJMYITEOX\n" +
            "BCJHMRMNK\n" +
            "BP\n" +
            "QVFABZ\n" +
            "PRGKSPUNA";
    String expected = "4";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "7\n" +
            "RABYBBE\n" +
            "JOZ\n" +
            "BMHQUVA\n" +
            "BPA\n" +
            "ISU\n" +
            "MCMABAOBHZ\n" +
            "SZMEHMA";
    String expected = "4";

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