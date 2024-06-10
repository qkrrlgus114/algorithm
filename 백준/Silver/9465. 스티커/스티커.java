import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());

            int[][] arr = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for (int i = 0; i < 2; i++) {
                String[] sa = bf.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(sa[j-1]);
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            if (N == 1) {
                sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");
                continue;
            }

            dp[0][2] = arr[1][1] + arr[0][2];
            dp[1][2] = arr[0][1] + arr[1][2];

            if (N == 2) {
                sb.append(Math.max(dp[0][2], dp[1][2])).append("\n");
                continue;
            }

            for (int i = 3; i <= N; i++) {
                dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + arr[1][i];
            }

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        System.out.println(sb);
    }
}


