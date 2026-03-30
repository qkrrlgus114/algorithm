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

        int[] arr = new int[N + K - 1];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        int idx = 0;
        for (int i = N; i < N + K - 1; i++) {
            arr[i] = arr[idx++];
        }

        int[] prefixSum = new int[N + K];

        int answer = 0;
        for (int i = 0; i < N + K - 1; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int e = K;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, prefixSum[e++] - prefixSum[i]);
        }

        System.out.println(answer);

    }

}