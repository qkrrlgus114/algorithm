import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        dp = new int[1001];
        dp[1] = dp[3] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++){
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }

        if(dp[N] % 2 == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}


