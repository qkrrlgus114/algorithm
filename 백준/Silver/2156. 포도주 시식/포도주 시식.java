import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        memo = new int[4][N+1];
        int[] wine = new int[N+1];
        for(int i=1; i<=N; i++){
            s = bf.readLine();
            wine[i] = Integer.parseInt(s);
        }

        memo[1][1] = 0;
        memo[2][1] = wine[1];
        memo[3][1] = wine[1];

        for(int i=2; i<=N; i++){
            memo[1][i] = Math.max(Math.max(memo[1][i-1], memo[2][i-1]), memo[3][i-1]);
            memo[2][i] = memo[1][i-1] + wine[i];
            memo[3][i] = memo[2][i-1] + wine[i];
        }

        System.out.println(Math.max(Math.max(memo[1][N], memo[2][N]), memo[3][N]));

    }
}

