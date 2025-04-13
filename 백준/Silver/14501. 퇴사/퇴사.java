import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static int[] T;
    static int[] P;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            T[i] = Integer.parseInt(sa[0]);
            P[i] = Integer.parseInt(sa[1]);
        }

        combination(0, 0);

        System.out.println(answer);
    }

    public static void combination(int depth, int sum) {
        // 종료 조건
        if (depth >= N) {
            answer = Math.max(answer, sum);
            return;
        }

        // 고르는 경우
        if (depth + T[depth] <= N) {
            combination(depth + T[depth], sum + P[depth]);
        }
        // 안고르는 경우
        combination(depth + 1, sum);
    }

}

