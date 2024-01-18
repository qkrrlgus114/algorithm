import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] step;
    static int[] memo;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        step = new int[N];
        memo = new int[N];

        for (int i = 0; i < N; i++) {
            n = bf.readLine();
            step[i] = Integer.parseInt(n);
        }

        if (N >= 3) {
            memo[0] = step[0];
            memo[1] = memo[0] + step[1];
            memo[2] = Math.max(memo[0], step[1]) + step[2];
            if(N == 3){
                System.out.println(memo[2]);
            }else{
                for (int i = 3; i < N; i++) {
                    memo[i] = Math.max(memo[i - 3] + step[i - 1], memo[i - 2]) + step[i];
                }
                System.out.println(memo[N - 1]);
            }
        } else {
            for (int i = 0; i < N; i++) {
                memo[0] += step[i];
            }
            System.out.println(memo[0]);
        }
    }
}