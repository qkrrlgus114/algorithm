import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 1. 모든 꽃을 피우게 해야 함.
     * 2. 가장 저렴한 화단을 대여하고 싶다.
     * <p>
     * 꽃은 1부터 N-2까지 심기 가능
     */

    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(sa[j]);
            }
        }

        dfs(0, 0);
        System.out.println(answer);

    }

    public static void dfs(int flowers, int sum) {
        if (flowers == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (visited[i][j] || visited[i - 1][j] || visited[i + 1][j] || visited[i][j - 1] || visited[i][j + 1])
                    continue;

                visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = true;
                dfs(flowers + 1, sum + board[i][j] + board[i - 1][j] + board[i + 1][j] + board[i][j - 1] + board[i][j + 1]);
                visited[i][j] = visited[i - 1][j] = visited[i + 1][j] = visited[i][j - 1] = visited[i][j + 1] = false;
            }
        }
    }
}
