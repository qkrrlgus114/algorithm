import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        answer = new int[N];

        recur(0);

        System.out.println(sb);
    }

    public static void recur(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            answer[depth] = i;
            recur(depth + 1);
            visited[i] = false;
        }
    }

}
