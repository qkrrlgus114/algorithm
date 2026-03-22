import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static long[] liquids;
    static long[] answer = new long[3];
    static long temp = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        liquids = new long[N];

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(liquids);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                binarySearch(liquids[i], liquids[j], j);
            }
        }

        Arrays.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);

    }

    private static void binarySearch(long a, long b, int idx) {
        int s = idx + 1;
        int e = N - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            long sum = a + b + liquids[m];
            if (Math.abs(sum) < Math.abs(temp)) {
                temp = sum;
                answer[0] = a;
                answer[1] = b;
                answer[2] = liquids[m];
            }

            if (sum > 0) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
    }

}