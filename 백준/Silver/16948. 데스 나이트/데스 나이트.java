import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 1, 2, 1, -1, -2};
    static int[] dy = {-2, -2, 0, 2, 2, 0};
    static int N;
    static boolean[][] visited;
    static int[] finish = new int[2];
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        visited = new boolean[N][N];

        String[] sa = bf.readLine().split(" ");
        int startY = Integer.parseInt(sa[0]);
        int startX = Integer.parseInt(sa[1]);
        finish[0] = Integer.parseInt(sa[2]);
        finish[1] = Integer.parseInt(sa[3]);

        bfs(startY, startX);

        System.out.println(answer);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int move = temp[2];

            // 정답 위치인지
            if (y == finish[0] && x == finish[1]) {
                answer = move;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;

                q.add(new int[]{ny, nx, move + 1});
            }
        }
    }
}