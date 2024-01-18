import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String t = bf.readLine();
        int T = Integer.parseInt(t);

        memo = new int[12];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;
        memo[4] = 7;

        for (int q = 0; q < T; q++) {
            t = bf.readLine();
            int N = Integer.parseInt(t);

            if(N > 4){
                int result = dp(N);
                System.out.println(result);
            }else{
                System.out.println(memo[N]);
            }
        }

    }

    public static int dp(int x){
        if(memo[x] != 0){
            return memo[x];
        }

        return memo[x] = dp(x-1) + dp(x-2) + dp(x-3);
    }
}
