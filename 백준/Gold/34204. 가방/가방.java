import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int C = Integer.parseInt(sa[2]);

        int[] product = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            product[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(product);

        // 누적합 배열
        long[] prefixSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + product[i];
        }

        StringBuilder sb = new StringBuilder();
        long sum = prefixSum[K];
        int start = 0;
        int end = K - 1;

        for (int x = 1; x <= C; x++) {
            if (prefixSum[start + 1] <= x) {
                if (end == N - 1) {
                    sb.append(sum).append("\n");
                    continue;
                }
                end++;
                sum += product[end] - product[start];
                start++;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}