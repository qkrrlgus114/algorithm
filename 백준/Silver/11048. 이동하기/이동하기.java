import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            sa = bf.readLine().split(" ");
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(sa[j-1]);
            }
        }

        int[][] dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + arr[i][j];
            }
        }

        System.out.println(dp[N][M]);
    }
}


