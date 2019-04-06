import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        solve(System.in, System.out);
    }

    static void solve(InputStream is, PrintStream os) {
        Scanner sc = new Scanner(is);
        int p[]  = new int[5];
        for (int i = 0; i < p.length; i++) {
            p[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (Math.abs(p[j] - p[i]) > k) {
                    os.println(":(");
                    return;
                }
            }
        }
        os.println("Yay!");
    }
}