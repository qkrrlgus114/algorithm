import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int zero = 0;
    static int one = 0;
    static StringBuilder sb = new StringBuilder();
    static Integer[][] memo = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());

            zero = 0;
            one = 0;

            Integer[] fibonacci = fibonacci(N);

            sb.append(fibonacci[0]).append(" ").append(fibonacci[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static Integer[] fibonacci(int N) {
        if(memo[N][0] == null || memo[N][1] == null){
            memo[N][0] = fibonacci(N-2)[0] + fibonacci(N-1)[0];
            memo[N][1] = fibonacci(N-2)[1] + fibonacci(N-1)[1];
        }

        return memo[N];
    }

}


