import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int N = Integer.parseInt(n);
        dp = new int[N+1][3];
        arr = new int[N+1][3];

        for(int i=1; i<=N; i++){
            String[] sa = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sa[0]);
            arr[i][1] = Integer.parseInt(sa[1]);
            arr[i][2] = Integer.parseInt(sa[2]);
        }

        int result = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        for(int i=0; i<3; i++){
            if(dp[N][i] < result) result = dp[N][i];
        }

        System.out.println(result);



    }

}