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

        // 누적합 배열 생성
        int[] prefix = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < M; t++) {
            sa = bf.readLine().split(" ");
            int s = Integer.parseInt(sa[0]);
            int e = Integer.parseInt(sa[1]);

            sb.append(prefix[e] - prefix[s - 1]).append("\n");
        }

        System.out.println(sb);
    }

}

