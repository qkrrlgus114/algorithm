import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        long[] arr = new long[M];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arr[i] = Long.parseLong(sa[i]);
        }

        long[] prefix = new long[M + 1];
        for (int i = 0; i < M; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            long candy = Long.parseLong(bf.readLine());

            int answer = binarySearch(prefix, candy, 0, M);
            sb.append(answer == Integer.MAX_VALUE ? "Go away!" : answer).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(long[] prefix, long candy, int s, int e) {
        int answer = Integer.MAX_VALUE;
        while (s <= e) {
            int m = (s + e) / 2;

            // M개의 개수를 넘는지 확인
            if (m > M) {
                e = m - 1;
            } else {
                if (candy <= prefix[m]) {
                    answer = Math.min(answer, m);
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
        }

        return answer;
    }

}