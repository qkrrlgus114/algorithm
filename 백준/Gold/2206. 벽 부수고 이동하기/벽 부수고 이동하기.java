import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] arr;
    static boolean[][][] visited;
    static int N, M;

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        arr = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = sa[0].charAt(j) - '0';
            }
        }

        int reuslt = bfs();

        if (N == 1 && M == 1) {
            System.out.println(1);
        } else {
            System.out.println(reuslt);
        }
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int step = temp[2];
            int wall = temp[3];

            for (int i = 0; i < 4; i++) {
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;
                if (ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;

                if (ndy == N - 1 && ndx == M - 1) {
                    return step + 1;
                }
                if (arr[ndy][ndx] == 1) {
                    // 부술 수 있는데 이미 방문했다면
                    if (wall == 0) {
                        if (visited[wall + 1][ndy][ndx]) {
                            continue;
                        }
                        visited[wall + 1][ndy][ndx] = true;
                        q.add(new int[]{ndy, ndx, step + 1, wall + 1});
                    }
                } else {
                    if (visited[wall][ndy][ndx]) {
                        continue;
                    }
                    visited[wall][ndy][ndx] = true;
                    q.add(new int[]{ndy, ndx, step + 1, wall});
                }

            }
        }

        return -1;
    }
}
