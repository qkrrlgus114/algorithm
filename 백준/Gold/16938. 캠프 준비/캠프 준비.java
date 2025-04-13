import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, L, R, X, answer;
    static int[] problems;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        L = Integer.parseInt(sa[1]);
        R = Integer.parseInt(sa[2]);
        X = Integer.parseInt(sa[3]);

        problems = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            problems[i] = Integer.parseInt(sa[i]);
        }

        combination(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, false);

        System.out.println(answer);

    }

    public static void combination(int depth, int choice, int sum, int minP, int maxP, boolean flag) {
        if (choice >= 2 && sum >= L && sum <= R && maxP - minP >= X && flag) {
            answer++;
        }
        if (depth >= N) return;

        // 문제를 고르는 경우
        combination(depth + 1, choice + 1, sum + problems[depth], Math.min(minP, problems[depth]), Math.max(maxP, problems[depth]), true);
        // 문제를 안고르는 경우
        combination(depth + 1, choice, sum, minP, maxP, false);
    }

}

