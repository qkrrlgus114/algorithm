import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int result = Integer.MAX_VALUE;

    // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(sa[j]);
            }
        }

        String[] sa = bf.readLine().split(" ");

        bfs(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]));

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int cnt = temp[2];

            for (int i = 0; i < 4; i++) {

                int ndx = x + dx[i];
                int ndy = y + dy[i];

                if (ndx < 0 || ndy < 0 || ndx >= 5 || ndy >= 5) continue;
                if (board[ndy][ndx] == -1) continue;

                // 정답인지
                if (board[ndy][ndx] == 1) {
                    result = Math.min(result, cnt + 1);
                    continue;
                }


                // 걷는 경우
                if (!visited[ndy][ndx]) {
                    visited[ndy][ndx] = true;
                    q.add(new int[]{ndy, ndx, cnt + 1});
                }

                if (board[ndy][ndx] == 7) {
                    continue;
                }


                // 뛰는 경우
                int[] point = run(ndy, ndx, i);
                int py = point[0];
                int px = point[1];
                if (visited[py][px]) {
                    continue;
                }
                visited[py][px] = true;
                if (board[py][px] == 1) {
                    result = Math.min(result, cnt + 1);
                    continue;
                }
                q.add(new int[]{py, px, cnt + 1});
            }
        }
    }

    public static int[] run(int y, int x, int dir) {
        int[] result = new int[2];
        // 위로 뛰는 경우
        if (dir == 0) {
            while (true) {
                y--;
                if (y < 0 || board[y][x] == -1) {
                    result[0] = y + 1;
                    result[1] = x;
                    break;
                }
                if (board[y][x] == 7) {
                    result[0] = y;
                    result[1] = x;
                    break;
                }
            }
        }
        // 아래로 뛰는 경우
        else if (dir == 1) {
            while (true) {
                y++;
                if (y >= 5 || board[y][x] == -1) {
                    result[0] = y - 1;
                    result[1] = x;
                    break;
                }
                if (board[y][x] == 7) {
                    result[0] = y;
                    result[1] = x;
                    break;
                }
            }
        }
        // 왼쪽으로 뛰는 경우
        else if (dir == 2) {
            while (true) {
                x--;
                if (x < 0 || board[y][x] == -1) {
                    result[0] = y;
                    result[1] = x + 1;
                    break;
                }
                if (board[y][x] == 7) {
                    result[0] = y;
                    result[1] = x;
                    break;
                }
            }
        }
        // 오른쪽으로 뛰는 경우
        else if (dir == 3) {
            while (true) {
                x++;
                if (x >= 5 || board[y][x] == -1) {
                    result[0] = y;
                    result[1] = x - 1;
                    break;
                }
                if (board[y][x] == 7) {
                    result[0] = y;
                    result[1] = x;
                    break;
                }
            }
        }

        return result;
    }


}
