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
        input += "101\n" +
                "86\n" +
                "119\n" +
                "108\n" +
                "57";

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Main.solve(
                new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
        );
        assertThat(os.toString(), is("481" + System.lineSeparator()));
    }

    @Test
    public void test2() {
        String input = "";
        input += "123\n" +
                "123\n" +
                "123\n" +
                "123\n" +
                "123";

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Main.solve(
                new ByteArrayInputStream(input.getBytes()), new PrintStream(os)
        );
        assertThat(os.toString(), is("643"
                + System.lineSeparator()));
    }

}