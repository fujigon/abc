package com.solver.atcoder.others.abc088.d;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "3 3\n"
        + "..#\n"
        + "#..\n"
        + "...";
    String expected = "2";
    
    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test1() {
    String input = "10 37\n"
        + ".....................................\n"
        + "...#...####...####..###...###...###..\n"
        + "..#.#..#...#.##....#...#.#...#.#...#.\n"
        + "..#.#..#...#.#.....#...#.#...#.#...#.\n"
        + ".#...#.#..##.#.....#...#.#.###.#.###.\n"
        + ".#####.####..#.....#...#..##....##...\n"
        + ".#...#.#...#.#.....#...#.#...#.#...#.\n"
        + ".#...#.#...#.##....#...#.#...#.#...#.\n"
        + ".#...#.####...####..###...###...###..\n"
        + ".....................................";
    String expected = "209";

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