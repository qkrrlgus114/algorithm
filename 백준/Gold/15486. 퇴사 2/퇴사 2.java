import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, answer;
    static List<int[]> list = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(sa[0]), Integer.parseInt(sa[1])});
        }

        for (int i = 0; i < N; i++) {
            int[] info = list.get(i);
            int day = info[0];
            int pay = info[1];

            // 상담을 하는 경우
            if (i + day <= N) {
                dp[i + day] = Math.max(dp[i + day], dp[i] + pay);
            }

            // 상담을 하지 않는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        int answer = 0;
        for (int i = 0; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }


        System.out.println(answer);
    }


}