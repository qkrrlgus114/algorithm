import java.io.*;
import java.util.*;

public class Main {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        memo = new int[N + 1];
        if (N >= 3) {
            memo[2] = memo[3] = 1;
        } else if (N == 2) {
            memo[2] = 1;
        }

        for (int i = 4; i <= N; i++) {
            if (i % 6 == 0) {
                memo[i] = Math.min(Math.min(memo[i / 2], memo[i / 3]), memo[i - 1]) + 1;
            } else if (i % 3 == 0) {
                memo[i] = Math.min(memo[i / 3], memo[i - 1]) + 1;
            } else if (i % 2 == 0) {
                memo[i] = Math.min(memo[i / 2], memo[i - 1]) + 1;
            } else {
                memo[i] = memo[i - 1] + 1;
            }
        }

        System.out.println(memo[N]);
    }


}
