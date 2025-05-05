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

        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");

            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            int answer = prefix[end] - prefix[start - 1];

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}