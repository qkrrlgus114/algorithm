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
        int Q = Integer.parseInt(sa[2]);
        int M = Integer.parseInt(sa[3]);

        boolean[] sleep = new boolean[N + 3];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            sleep[Integer.parseInt(sa[i])] = true;
        }

        int[] arr = new int[N + 3];

        sa = bf.readLine().split(" ");
        for (int i = 0; i < Q; i++) {
            int invite = Integer.parseInt(sa[i]);
            if (sleep[invite]) continue;
            for (int j = invite; j <= N + 2; j += invite) {
                if (!sleep[j]) {
                    arr[j] = 1;
                }
            }
        }
        
        // 누적합 계산
        int[] prefix = new int[N + 3];
        for (int i = 1; i < N + 3; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int s = Integer.parseInt(sa[0]);
            int e = Integer.parseInt(sa[1]);

            int totalStu = e - (s - 1);
            int joinStu = prefix[e] - prefix[s - 1];

            sb.append(totalStu - joinStu).append("\n");
        }


        System.out.println(sb);

    }

}


