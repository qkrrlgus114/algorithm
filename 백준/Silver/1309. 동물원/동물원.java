import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static long[][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        memo = new long[N][3];
        memo[0][0] = memo[0][1] = memo[0][2] = 1;

        for (int i = 1; i < N; i++) {
            memo[i][0] = (memo[i - 1][0] + memo[i - 1][1] + memo[i - 1][2]) % 9901;
            memo[i][1] = (memo[i - 1][0] + memo[i - 1][2]) % 9901;
            memo[i][2] = (memo[i - 1][0] + memo[i - 1][1]) % 9901;
        }

        System.out.println((memo[N - 1][0] + memo[N - 1][1] + memo[N - 1][2]) % 9901);
    }

}