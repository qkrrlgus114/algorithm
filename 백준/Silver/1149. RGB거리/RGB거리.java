import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static int answer = Integer.MAX_VALUE;
    static List<int[]> arr = new ArrayList<>();
    static int[][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        memo = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            arr.add(new int[]{Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])});
            Arrays.fill(memo[i], -1);
        }

        int red = dp(0, 0);
        int green = dp(0, 1);
        int blue = dp(0, 2);

        System.out.println(Math.min(Math.min(red, green), blue));
    }

    public static int dp(int cur, int prev) {
        if (cur == N) {
            return 0;
        }
        if (memo[cur][prev] != -1) {
            return memo[cur][prev];
        }

        int value = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == prev) continue;
            value = Math.min(value, dp(cur + 1, i) + arr.get(cur)[i]);
        }

        return memo[cur][prev] = value;
    }

}