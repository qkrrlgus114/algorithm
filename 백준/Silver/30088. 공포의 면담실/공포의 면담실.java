import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        long[] arr = new long[N];
        for (int t = 0; t < N; t++) {
            String[] sa = bf.readLine().split(" ");

            int humanCount = Integer.parseInt(sa[0]);
            for (int i = 1; i <= humanCount; i++) {
                arr[t] += Long.parseLong(sa[i]);
            }
        }

        Arrays.sort(arr);

        long[] prefix = new long[N + 1];
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += prefix[i];
        }
        System.out.println(answer);
    }

}