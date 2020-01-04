package abc.abc123.d;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {

  @Test
  public void test() {
    String input = "2 2 2 8\n" +
        "4 6\n" +
        "1 5\n" +
        "3 8";

    String expected = "19\n" +
        "17\n" +
        "15\n" +
        "14\n" +
        "13\n" +
        "12\n" +
        "10\n" +
        "8";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test2() {
    String input = "3 3 3 5\n" +
        "1 10 100\n" +
        "2 20 200\n" +
        "1 10 100";

    String expected = "400\n" +
        "310\n" +
        "310\n" +
        "301\n" +
        "301";

    assertThat(execute(input + "\n"), is(expected + "\n"));
  }

  @Test
  public void test3() {
    String input = "10 10 10 20\n" +
        "7467038376 5724769290 292794712 2843504496 3381970101 8402252870 249131806 6310293640 6690322794 6082257488\n"
        +
        "1873977926 2576529623 1144842195 1379118507 6003234687 4925540914 3902539811 3326692703 484657758 2877436338\n"
        +
        "4975681328 8974383988 2882263257 7690203955 514305523 6679823484 4263279310 585966808 3752282379 620585736";

    String expected = "23379871545\n" +
        "22444657051\n" +
        "22302177772\n" +
        "22095691512\n" +
        "21667941469\n" +
        "21366963278\n" +
        "21287912315\n" +
        "21279176669\n" +
        "21160477018\n" +
        "21085311041\n" +
        "21059876163\n" +
        "21017997739\n" +
        "20703329561\n" +
        "20702387965\n" +
        "20590247696\n" +
        "20383761436\n" +
        "20343962175\n" +
        "20254073196\n" +
        "20210218542\n" +
        "20150096547";

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