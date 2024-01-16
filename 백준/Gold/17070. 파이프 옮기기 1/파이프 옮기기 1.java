import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int result = 0;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        map = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        // 초기값
        dp[0][1][0] = 1;

        for(int i=0; i<N; i++){
            for(int j=2; j<N; j++){
                if(map[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
                if(i != 0){
                    // 세로
                    dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
                    // 대각선
                    if(map[i-1][j] != 1 && map[i][j-1] != 1){
                        dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                    }
                }
            }
        }
        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}