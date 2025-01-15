import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] graph;
    static int N;
    static boolean success = false;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }

        visited[0][0] = true;
        dfs(0, 0, graph[0][0]);

        System.out.println(success ? "HaruHaru" : "Hing");

    }

    public static void dfs(int y, int x, int cnt) {
        if (graph[y][x] == -1) {
            success = true;
            return;
        }
        // 오른쪽 이동
        if (x + cnt < N && !visited[y][x + cnt]) {
            visited[y][x + cnt] = true;
            dfs(y, x + cnt, graph[y][x + cnt]);
            visited[y][x + cnt] = false;
            if (success) return;
        }

        // 아래로 이동
        if (y + cnt < N && !visited[y + cnt][x]) {
            visited[y + cnt][x] = true;
            dfs(y + cnt, x, graph[y + cnt][x]);
            visited[y + cnt][x] = false;
        }

    }

}