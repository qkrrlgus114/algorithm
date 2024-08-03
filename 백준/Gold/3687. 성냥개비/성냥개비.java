import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        long[] dp = new long[101];
        int[] arr = {1, 7, 4, 2, 0, 8};
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;

        // 가능한 최솟값 구하기
        for(int i=9; i<=100; i++){
            for(int j=2; j<=7; j++){
                String temp = String.valueOf(dp[i - j]) + String.valueOf(arr[j - 2]);
                dp[i] = Math.min(Long.parseLong(temp), dp[i]);
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(bf.readLine());

            sb.append(dp[N]).append(" ");

            // 최댓값 구하기
            // 짝수면
            if(N % 2 == 0){
                for(int i=0; i<N/2; i++){
                    sb.append("1");
                }
                sb.append("\n");
            }else{
                sb.append("7");
                for(int i=0; i<(N - 3)/2; i++){
                    sb.append("1");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());



    }
}