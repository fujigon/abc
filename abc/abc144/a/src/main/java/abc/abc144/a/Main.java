package abc.abc144.a;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solve(System.in, System.out);
    }

    static void solve(InputStream is, PrintStream os) {
        Scanner sc = new Scanner(is);

        /* read */
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (0 < a && a <= 9 && 0 < b && b <= 9) {
            os.println(a * b);
        } else {
            os.println(-1);
        }
    }
}