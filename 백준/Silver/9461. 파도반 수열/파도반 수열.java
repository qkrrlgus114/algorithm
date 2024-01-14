import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static Long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int T = Integer.parseInt(n);
        for(int t=0; t<T; t++){
            n = bf.readLine();
            int N = Integer.parseInt(n);

            dp = new Long[N + 1];
            if(N <= 3){
                System.out.println(1);
            }else{
                for(int i=1; i<=3; i++){
                    dp[i] = 1L;
                }

                for(int i=4; i<=N; i++){
                    dp[i] = dp[i-2] + dp[i-3];
                }
                System.out.println(dp[N]);
            }
        }


    }

}