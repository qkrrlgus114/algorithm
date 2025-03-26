import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board = new int[5][5];

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(sa[j]);
            }
        }

        String[] sa = bf.readLine().split(" ");
        int initY = Integer.parseInt(sa[0]);
        int initX = Integer.parseInt(sa[1]);
        dfs(initY, initX, 0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void dfs(int y, int x, int apple, int step) {
        if (apple == 3) {
            answer = Math.min(answer, step);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ndx = dx[i] + x;
            int ndy = dy[i] + y;
            if (ndx < 0 || ndy < 0 || ndx >= 5 || ndy >= 5) continue;
            if (board[ndy][ndx] == -1) continue;

            // 기존 값
            int origin = board[y][x];
            board[y][x] = -1;
            if (board[ndy][ndx] == 1) {
                dfs(ndy, ndx, apple + 1, step + 1);
            } else {
                dfs(ndy, ndx, apple, step + 1);
            }
            board[y][x] = origin;
        }
    }
}
