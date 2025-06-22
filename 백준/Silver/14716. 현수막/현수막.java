import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 상 하 좌 우 왼상 우상 우하 왼하
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    static int M, N, answer;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        M = Integer.parseInt(sa[0]);
        N = Integer.parseInt(sa[1]);
        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(sa[j]);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];

            for (int i = 0; i < 8; i++) {
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;

                if (ndy < 0 || ndx < 0 || ndy >= M || ndx >= N) continue;
                if (board[ndy][ndx] != 1) continue;
                board[ndy][ndx] = 2;
                q.add(new int[]{ndy, ndx});
            }
        }
    }
}