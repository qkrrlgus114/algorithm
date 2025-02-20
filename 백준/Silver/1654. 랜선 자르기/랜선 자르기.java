import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int K = Integer.parseInt(sa[0]);
        int N = Integer.parseInt(sa[1]);

        int[] lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(bf.readLine());
        }

        long s = 1;
        long e = Integer.MAX_VALUE;
        long answer = 0;

        while (s <= e) {
            long m = (s + e) / 2;

            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += lines[i] / m;
            }
            // 필요한 랜선을 충족했다면
            if (cnt >= N) {
                answer = Math.max(answer, m);
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.println(answer);
    }


}
