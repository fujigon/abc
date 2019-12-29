package abc127.b;

import abc127.b.Main;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 10 20";
    String expected = "30\n"
        + "50\n"
        + "90\n"
        + "170\n"
        + "330\n"
        + "650\n"
        + "1290\n"
        + "2570\n"
        + "5130\n"
        + "10250";

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