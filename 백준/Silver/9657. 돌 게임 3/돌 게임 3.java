import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] dp = new boolean[]{false, true, false, true, true, true, true};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        System.out.println(dp[N % 7] ? "SK" : "CY");

    }
}