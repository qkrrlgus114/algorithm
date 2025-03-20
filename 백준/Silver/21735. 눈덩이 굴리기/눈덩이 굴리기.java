import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] snows;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        snows = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            snows[i] = Integer.parseInt(sa[i]);
        }

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    public static void dfs(int time, int depth, int sum) {
        // 시간이 다되었거나, 끝에 도달했다면
        if (time == M || depth == N) {
            answer = Math.max(answer, sum);
            return;
        }

        dfs(time + 1, depth + 1, sum + snows[depth]);
        if (depth + 1 >= N) return;
        dfs(time + 1, depth + 2, (sum / 2) + snows[depth + 1]);
    }

}
