import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] temp;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
//    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        temp = new int[M];
//        visited = new boolean[N];

        dfs(0, 1);

        System.out.println(sb);
    }

    public static void dfs(int depth, int idx) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i <= N; i++) {
//            if (visited[i - 1]) continue;
            temp[depth] = i;
//            visited[i - 1] = true;
            dfs(depth + 1, i);
//            visited[i - 1] = false;
        }
    }

}