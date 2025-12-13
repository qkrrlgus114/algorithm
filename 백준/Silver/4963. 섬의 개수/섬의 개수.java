import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 12시부터 시계방향
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] sa = bf.readLine().split(" ");
            if ("0".equals(sa[0]) && "0".equals(sa[1])) {
                break;
            }

            w = Integer.parseInt(sa[0]);
            h = Integer.parseInt(sa[1]);

            int[][] ground = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            int result = 0;

            for (int i = 0; i < h; i++) {
                sa = bf.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    ground[i][j] = Integer.parseInt(sa[j]);
                }
            }

            // 반복문을 통해 1인 섬을 탐색
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (ground[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        result++;
                        bfs(i, j, ground, visited);
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs(int y, int x, int[][] ground, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for (int i = 0; i < 8; i++) {
                int ndy = y + dy[i];
                int ndx = x + dx[i];
                if (ndy < 0 || ndx < 0 || ndy >= h || ndx >= w) {
                    continue;
                }
                if (ground[ndy][ndx] != 1 || visited[ndy][ndx]) {
                    continue;
                }

                visited[ndy][ndx] = true;
                q.add(new int[]{ndy, ndx});
            }
        }
    }

}
