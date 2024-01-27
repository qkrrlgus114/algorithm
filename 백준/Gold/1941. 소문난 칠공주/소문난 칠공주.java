import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] graph = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    //상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            char[] sa = bf.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                graph[i][j] = sa[j];
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int depth, int start) {
        // 7명 다 뽑았다면
        if (depth == 7) {
            // 전부 이어져있는지 확인
            if (bfs()) {
                result++;
                return;
            }
        }

        for (int i = start; i < 25; i++) {
            visited[i / 5][i % 5] = true;
            dfs(depth + 1, i + 1);
            visited[i / 5][i % 5] = false;
        }
    }

    public static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[5][5];

        int y = 0;
        int x = 0;
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    y = i;
                    x = j;
                    break outer;
                }
            }
        }

        int ids = 0;
        int cnt = 1;
        if (graph[y][x] == 'S') ids++;

        q.add(new int[]{y, x});
        check[y][x] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int ny = temp[0];
            int nx = temp[1];

            for (int i = 0; i < 4; i++) {
                int ndx = nx + dx[i];
                int ndy = ny + dy[i];
                if (ndx >= 0 && ndy >= 0 && ndy < 5 && ndx < 5) {
                    if (visited[ndy][ndx] && !check[ndy][ndx]) {
                        check[ndy][ndx] = true;
                        q.add(new int[]{ndy, ndx});
                        cnt++;
                        if (graph[ndy][ndx] == 'S') ids++;
                    }
                }
            }
        }

        if (cnt == 7 && ids >= 4) {
            return true;
        }
        return false;
    }
}