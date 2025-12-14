import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int M, N, H;
    static int[][][] arr;
    static boolean[][][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] dh = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        M = Integer.parseInt(sa[0]);
        N = Integer.parseInt(sa[1]);
        H = Integer.parseInt(sa[2]);

        arr = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                sa = bf.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    arr[h][i][j] = Integer.parseInt(sa[j]);
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[h][i][j] == 1) {
                        list.add(new int[]{h, i, j, 0});
                    }
                }
            }
        }

        int reuslt = bfs(list);

        boolean check = true;
        outer:
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[h][i][j] == 0 && !visited[h][i][j]) {
                        check = false;
                        break outer;
                    }
                }
            }
        }

        System.out.println(check ? reuslt : -1);
    }

    public static int bfs(List<int[]> list) {

        Queue<int[]> q = new LinkedList<>();
        for (int[] arr : list) {
            q.add(arr);
        }
        int result = 0;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int h = temp[0];
            int y = temp[1];
            int x = temp[2];
            int cnt = temp[3];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;

                if (ndx < 0 || ndy < 0 || ndx >= M || ndy >= N || visited[h][ndy][ndx] || arr[h][ndy][ndx] == -1
                        || arr[h][ndy][ndx] == 1) {
                    continue;
                }

                visited[h][ndy][ndx] = true;
                q.add(new int[]{h, ndy, ndx, cnt + 1});
                result = Math.max(result, cnt + 1);
            }

            // 위아래 탐색
            for (int i = 0; i < 2; i++) {
                int ndh = dh[i] + h;

                if (ndh < 0 || ndh >= H || visited[ndh][y][x] || arr[ndh][y][x] == -1 || arr[ndh][y][x] == 1) {
                    continue;
                }

                visited[ndh][y][x] = true;
                q.add(new int[]{ndh, y, x, cnt + 1});
                result = Math.max(result, cnt + 1);
            }
        }

        return result;
    }

}
