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

        long sum;

        public long getSum() {
            return sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Indexes indexes = (Indexes) o;

            if (xi != indexes.xi) return false;
            if (yi != indexes.yi) return false;
            if (zi != indexes.zi) return false;
            return sum == indexes.sum;

        }

        @Override
        public int hashCode() {
            int result = xi;
            result = 31 * result + yi;
            result = 31 * result + zi;
            result = 31 * result + (int) (sum ^ (sum >>> 32));
            return result;
        }
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

        Queue<Indexes> queue = new PriorityQueue<>(
                Comparator.comparingLong(Indexes::getSum).reversed()
        );

        Indexes initial = new Indexes();
        initial.xi = 0;
        initial.yi = 0;
        initial.zi = 0;
        calculateSum(initial, xs, ys, zs);
        queue.add(initial);

        Set<Indexes> queued = new HashSet<>();
        queued.add(initial);

        for (long i = 0; i < k; i++) {
            Indexes indexes = queue.remove();

            os.println(indexes.sum);

            if (indexes.xi < x - 1) {
                Indexes xInc = new Indexes();
                xInc.xi = indexes.xi + 1;
                xInc.yi = indexes.yi;
                xInc.zi = indexes.zi;

                calculateSum(xInc, xs, ys, zs);

                if (!queued.contains(xInc)) {
                    queue.add(xInc);
                    queued.add(xInc);
                }
            }

            if (indexes.yi < y - 1) {
                Indexes yInc = new Indexes();

                yInc.xi = indexes.xi;
                yInc.yi = indexes.yi + 1;
                yInc.zi = indexes.zi;

                calculateSum(yInc, xs, ys, zs);

                if (!queued.contains(yInc)) {
                    queue.add(yInc);
                    queued.add(yInc);
                }
            }

            if (indexes.zi < z - 1) {
                Indexes zInc = new Indexes();
                zInc.xi = indexes.xi;
                zInc.yi = indexes.yi;
                zInc.zi = indexes.zi + 1;

                calculateSum(zInc, xs, ys, zs);

                if (!queued.contains(zInc)) {
                    queue.add(zInc);
                    queued.add(zInc);
                }
            }
        }
    }

    private static void calculateSum(Indexes indexes, List<Long> xs, List<Long> ys, List<Long> zs) {
        indexes.sum = xs.get(indexes.xi) + ys.get(indexes.yi) + zs.get(indexes.zi);
    }

}