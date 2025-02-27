import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
            min = Math.min(min, arr[i]);
        }

        long result = (long) min * M;
        long s = 0;
        long e = (long) min * M;

        while (s <= e) {
            long m = (s + e) / 2;

            // 불 수 있는 풍선의 총 합
            long value = 0;
            for (int i = 0; i < N; i++) {
                value += m / arr[i];
            }

            if (value < M) {
                s = m + 1;
            } else {
                result = Math.min(result, m);
                e = m - 1;
            }
        }

        System.out.println(result);
    }
}

