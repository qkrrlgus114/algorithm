import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int cnt = 0;
            String[] sa = bf.readLine().split(" ");

            int N = Integer.parseInt(sa[0]);
            int M = Integer.parseInt(sa[1]);

            if (N == 0 && M == 0) break;

            int[] sang = new int[N];
            int[] sun = new int[M];

            for (int i = 0; i < N; i++) {
                sang[i] = Integer.parseInt(bf.readLine());
            }

            for (int j = 0; j < M; j++) {
                sun[j] = Integer.parseInt(bf.readLine());
            }

            int sangL = 0;
            int sunL = 0;
            while (sangL < N && sunL < M) {
                if (sang[sangL] == sun[sunL]) {
                    cnt++;
                    sangL++;
                    sunL++;
                } else if (sang[sangL] > sun[sunL]) {
                    sunL++;
                } else {
                    sangL++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}