import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board = new int[5][5];
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(sa[j]);
            }
        }

        String[] sa = bf.readLine().split(" ");
        dfs(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int y, int x, int apple, int step) {
        if (apple == 2) {
            answer = 1;
            return;
        }
        if (step >= 3) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ndx = dx[i] + x;
            int ndy = dy[i] + y;

            if (ndx < 0 || ndy < 0 || ndx >= 5 || ndy >= 5) continue;
            if (board[ndy][ndx] == -1) continue;

            // 기존 위치의 값을 기억
            int origin = board[y][x];
            // 기존 위치를 장애물로 변경
            board[y][x] = -1;
            if (board[ndy][ndx] == 1) {
                dfs(ndy, ndx, apple + 1, step + 1);
            } else {
                dfs(ndy, ndx, apple, step + 1);
            }
            // 기존 위치를 다시 원상복구
            board[y][x] = origin;
        }
    }

}
