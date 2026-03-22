import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int K;
    static int[] drinks;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        drinks = new int[N];

        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(bf.readLine());
        }

        binarySearch();

        System.out.println(answer);

    }

    private static void binarySearch() {
        long s = 0;
        long e = Integer.MAX_VALUE;

        while (s <= e) {
            // 막걸리 분배 용량
            long m = (s + e) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (drinks[i] == 0) continue;
                sum += drinks[i] / m;
            }

            if (sum >= K) {
                answer = Math.max(answer, m);
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
    }

}