import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        solve(System.in, System.out);
    }

    private static class Indexes {
        int xi;
        int yi;
        int zi;
    }

    static void solve(InputStream is, PrintStream os) {
        Scanner sc = new Scanner(is);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();

        // long[] xarray = new long[x];
        List<Long> xs = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            // xarray[i] = sc.nextLong();
            xs.add(sc.nextLong());
        }
        // long[] yarray = new long[y];
        List<Long> ys = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            // yarray[i] = sc.nextLong();
            ys.add(sc.nextLong());
        }
        // long[] zarray = new long[z];
        List<Long> zs = new ArrayList<>();
        for (int i = 0; i < z; i++) {
            // zarray[i] = sc.nextLong();
            zs.add(sc.nextLong());
        }
        xs.sort(Long::compareTo);
        ys.sort(Long::compareTo);
        zs.sort(Long::compareTo);
        Collections.reverse(xs);
        Collections.reverse(ys);
        Collections.reverse(zs);

        Indexes dp[] = new Indexes[k];
        dp[0] = new Indexes();
        dp[0].xi = 0;
        dp[0].yi = 0;
        dp[0].zi = 0;

        for (int i = 0; i < k; i++) {
            long xdiff = 0;
            if (dp[i].xi + 1 < x) {
                xdiff = xs.get(dp[i].xi) - xs.get(dp[i].xi + 1);
            }
            long ydiff = 0;
            if (dp[i].yi + 1 < y) {
                ydiff = ys.get(dp[i].yi) - ys.get(dp[i].yi + 1);
            }
            long zdiff = 0;
            if (dp[i].yi + 1 < z) {
                zdiff = zs.get(dp[i].zi) - zs.get(dp[i].zi + 1);
            }
            dp[i + 1] = new Indexes();
            if (xdiff <= ydiff && xdiff <= zdiff) {
                dp[i + 1].xi = dp[i].xi + 1;
                dp[i + 1].yi = dp[i].yi;
                dp[i + 1].zi = dp[i].zi;
            } else if (ydiff <= zdiff) {
                dp[i + 1].xi = dp[i].xi;
                dp[i + 1].yi = dp[i].yi + 1;
                dp[i + 1].zi = dp[i].zi;
            } else {
                dp[i + 1].xi = dp[i].xi;
                dp[i + 1].yi = dp[i].yi;
                dp[i + 1].zi = dp[i].zi + 1;
            }
            os.println(xs.get(dp[i].xi) + ys.get(dp[i].yi) + zs.get(dp[i].zi));
        }
    }

}