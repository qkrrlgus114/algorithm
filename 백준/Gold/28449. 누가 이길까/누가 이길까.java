import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] hi;
    static int[] arc;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");

        hi = new int[N];
        arc = new int[M];
        for (int i = 0; i < N; i++) {
            hi[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(hi);

        sa = bf.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arc[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arc);

        long hiWin = 0;
        long arcWin = 0;
        long draw = 0;

        for (int i = 0; i < N; i++) {
            int target = hi[i];
            int lowerBound = lowerBound(0, M - 1, target);
            int upperBound = upperBound(0, M - 1, target);
            hiWin += lowerBound;
            draw += upperBound - lowerBound;
            arcWin += M - upperBound;
        }

        System.out.println(hiWin + " " + arcWin + " " + draw);
    }


    // target이 처음 등장하는 시점 (value가 해당 인덱스를 의미)
    public static int lowerBound(int s, int e, int target) {
        int value = arc.length;

        while (s <= e) {
            int m = (s + e) / 2;
            if (arc[m] >= target) {
                value = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return value;
    }

    // target 초과가 처음 등장하는 시점 (value가 해당 인덱스를 의미)
    public static int upperBound(int s, int e, int target) {
        int value = arc.length;

        while (s <= e) {
            int m = (s + e) / 2;
            if (arc[m] > target) {
                value = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return value;
    }


}
