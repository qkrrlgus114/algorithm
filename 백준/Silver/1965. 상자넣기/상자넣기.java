import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] size = new int[N + 2];
        int[] dp = new int[N + 2];

        int max = 0;

        String[] sa = bf.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            size[i] = Integer.parseInt(sa[i - 1]);
            dp[i] = 1;
        }

        dp[1] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (size[j] < size[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }


        System.out.println(max);
    }
}

