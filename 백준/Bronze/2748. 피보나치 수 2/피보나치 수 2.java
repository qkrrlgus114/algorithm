import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        memo = new long[N+1];

        long dp = dp(N);

        System.out.println(dp);

    }

    public static long dp(int n){
        if(n == 1 || n == 2) return 1;
        if(n == 0) return 0;
        if(memo[n] != 0) return memo[n];
        memo[n] = dp(n-1) + dp(n-2);

        return memo[n];
    }
}

