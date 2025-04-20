import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K, answer;
    static int[][] backPack;
    static int[][] memo; // 최대 가치를 저장해놓을

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        backPack = new int[N][2];
        memo = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            backPack[i][0] = Integer.parseInt(sa[0]);
            backPack[i][1] = Integer.parseInt(sa[1]);
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                memo[i][j] = -1;
            }
        }

        dp(0, 0);


        int answer = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                answer = Math.max(answer, memo[i][j]);
            }
        }

        System.out.println(answer);
    }

    public static int dp(int depth, int weight) {
        if (depth == N) {
            return 0;
        }

        if (memo[depth][weight] != -1) {
            return memo[depth][weight]; // 이미 해당 무게일 때 최대 가치가 들어있음
        }

        // 고르지 않는 경우
        int value = dp(depth + 1, weight);

        // 고르는 경우
        if (weight + backPack[depth][0] <= K) {
            value = Math.max(value, dp(depth + 1, weight + backPack[depth][0]) + backPack[depth][1]);
        }

        return memo[depth][weight] = value;
    }


}