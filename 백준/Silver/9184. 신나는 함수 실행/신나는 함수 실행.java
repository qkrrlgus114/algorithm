import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] sa = bf.readLine().split(" ");
            if (Integer.parseInt(sa[0]) == -1 && Integer.parseInt(sa[1]) == -1 && Integer.parseInt(sa[2]) == -1) {
                break;
            }
            int result = w(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2]));
            sb.append("w(" + sa[0] + ", " + sa[1] + ", " + sa[2] + ") = " + result + "\n");
        }
        System.out.println(sb.toString());
    }

    public static int w(int a, int b, int c) {

        if (a >= 0 && b >= 0 && c >= 0 && a <= 20 && b <= 20 && c <= 20 && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}