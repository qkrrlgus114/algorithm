import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(bf.readLine());
        memo = new int[N + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        for (int i = 1; i <= N; i++) {
            if (i >= 2 && memo[i - 2] != -1) {
                memo[i] = memo[i] == -1 ? memo[i - 2] + 1 : Math.min(memo[i], memo[i - 2] + 1);
            }
            if (i >= 5 && memo[i - 5] != -1) {
                memo[i] = memo[i] == -1 ? memo[i - 5] + 1 : Math.min(memo[i], memo[i - 5] + 1);
            }
        }

        System.out.println(memo[N]);


    }

}