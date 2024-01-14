import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int N = Integer.parseInt(n);

        dp = new int[N + 1];
        if(N > 2){
            dp[1] = 1;
            dp[2] = 2;
            int result = zeroOne(N);
            System.out.println(result);
        }else if(N == 1){
            System.out.println(1);
        }else{
            System.out.println(2);
        }
    }

    public static int zeroOne(int N){
        if(dp[N] != 0){
            return dp[N] % 15746;
        }

        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] % 15746 + dp[i-2] % 15746) % 15746;
        }

        return dp[N];
    }

}