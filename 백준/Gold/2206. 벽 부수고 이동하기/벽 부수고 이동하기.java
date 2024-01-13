import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int N;
    static int M;
    // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] s = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = s[j] - 48;
            }
        }

        int bfs = 0;
        if (map[0][0] == 1) {
            bfs = bfs(0, 0, 1, 1);
        } else {
            bfs = bfs(0, 0, 0, 1);
        }

        if(N == 1 && M == 1){
            System.out.println(1);
        }else{
            System.out.println(bfs);
        }

    }

    public static int bfs(int y, int x, int wall, int step) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, wall, step});
        visited[y][x][0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int cur_wall = temp[2];
            int cur_step = temp[3];

            for (int i = 0; i < 4; i++) {
                int ndx = x + dx[i];
                int ndy = y + dy[i];
                if (ndx >= 0 && ndy >= 0 && ndx < M && ndy < N) {
                    // 현재 위치가 벽인데 아직 부수지 않은 상태면
                    if (map[ndy][ndx] == 1 && cur_wall == 0 && !visited[ndy][ndx][1]) {
                        visited[ndy][ndx][1] = true;
                        if (ndy == N - 1 && ndx == M - 1) {
                            return cur_step + 1;
                        }
                        q.add(new int[]{ndy, ndx, 1, cur_step + 1});
                    } else if (map[ndy][ndx] == 0 && !visited[ndy][ndx][cur_wall]) {
                        visited[ndy][ndx][cur_wall] = true;
                        if (ndy == N - 1 && ndx == M - 1) {
                            return cur_step + 1;
                        }
                        q.add(new int[]{ndy, ndx, cur_wall, cur_step + 1});
                    }
                }
            }
        }
        return -1;
    }
}