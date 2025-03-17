import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int R, C, K;
    static char[][] board;
    static boolean[][] visited;
    static int answer = 0;

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        R = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);
        K = Integer.parseInt(sa[2]);

        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = bf.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(answer);
    }

    public static void dfs(int y, int x, int step) {
        // 목적지에 도착했다면
        if (y == 0 && x == C - 1 && step == K) {
            answer++;
            return;
        }

        // step이 넘었다면(목적지 도착 못함 -> 판단 안해도 됨)
        if (step >= K) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ndx = x + dx[i];
            int ndy = y + dy[i];

            if (ndx < 0 || ndy < 0 || ndx >= C || ndy >= R) continue;
            if (visited[ndy][ndx]) continue;
            if (board[ndy][ndx] == 'T') continue;

            visited[ndy][ndx] = true;
            dfs(ndy, ndx, step + 1);
            visited[ndy][ndx] = false;
        }

    }


}
