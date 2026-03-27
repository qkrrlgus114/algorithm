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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (prefixSum[j] - prefixSum[i] == M) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}