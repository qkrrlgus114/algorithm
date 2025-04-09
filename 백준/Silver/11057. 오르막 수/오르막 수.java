import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[][] Dp = new int[N + 1][10];
        int mod = 10007;
        for (int i = 0; i <= 9; i++) {
            Dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    Dp[i][j] += Dp[i - 1][k] % mod;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += Dp[N][i];
            sum %= mod;
        }
        System.out.println(sum);
    }

}

