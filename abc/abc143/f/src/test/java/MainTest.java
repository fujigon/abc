import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

  @Test
  public void test() {
    String input = "3\n"
        + "3 6 5";

    String expected = "12";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

//  @Test
//  public void test2() {
//    String input = "4\n"
//        + "23 36 66 65";
//
//    String expected = "188";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
//  }
//
//  @Test
//  public void test3() {
//    String input = "20\n"
//        + "1008288677408720767 539403903321871999 1044301017184589821 215886900497862655 504277496111605629 972104334925272829 792625803473366909 972333547668684797 467386965442856573 755861732751878143 1151846447448561405 467257771752201853 683930041385277311 432010719984459389 319104378117934975 611451291444233983 647509226592964607 251832107792119421 827811265410084479 864032478037725181";
//
//    String expected = "2012721721873704572";
//
//    assertThat(execute(input + "\n"), is(expected + "\n"));
//  }

  private String execute(String input) {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    Main.solve(
        new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
    );
    return os.toString().replace(System.lineSeparator(), "\n");
  }
}