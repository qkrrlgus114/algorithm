import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][][] memo = new int[51][51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] sa = bf.readLine().split(" ");
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int c = Integer.parseInt(sa[2]);

            if(a == -1 && b == -1 && c == -1) break;

            int dp = dp(a, b, c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(dp).append("\n");

        }
        System.out.println(sb);

    }

    public static int dp(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(memo[a][b][c] != 0) return memo[a][b][c];
        if(a > 20 || b > 20 || c > 20) return memo[a][b][c] = dp(20,20,20);
        if(a < b && b < c) return memo[a][b][c] = dp(a, b, c-1) + dp(a, b-1, c-1) - dp(a, b-1, c);
        return memo[a][b][c] = dp(a-1, b, c) + dp(a-1, b-1, c) + dp(a-1, b, c-1) - dp(a-1, b-1, c-1);
    }
}

