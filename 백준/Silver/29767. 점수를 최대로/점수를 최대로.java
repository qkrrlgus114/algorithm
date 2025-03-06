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

        long[] arr = new long[N];
        sa = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(sa[i]);
        }

        long[] prefix = new long[N];
        prefix[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        Arrays.sort(prefix);

        long sum = 0;
        int index = N - 1;
        for (int i = 0; i < K; i++) {
            sum += prefix[index--];
        }

        System.out.println(sum);

    }

}