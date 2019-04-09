import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "";
    input += "1 2 3 4 8 9 15" + System.lineSeparator();

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    assertThat(os.toString(), is("Yay!" + System.lineSeparator()));
  }

  @Test
  public void test2() {
    String input = "";
    input += "15 18 26 35 36 18" + System.lineSeparator();

    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    assertThat(os.toString(), is(":(" + System.lineSeparator()));
  }

}