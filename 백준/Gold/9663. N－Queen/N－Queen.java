import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] board;
    static long answer;
    // 열에 놨는지 체크
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];
        visited = new boolean[N];

        permutation(0);

        System.out.println(answer);
    }

    public static void permutation(int queen) {
        if (queen == N) {
            answer++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (visited[j]) continue;
            if (checkQueen(queen, j)) {
                visited[j] = true;
                board[queen][j] = 1;
                permutation(queen + 1);
                visited[j] = false;
                board[queen][j] = 0;
            }
        }
    }

    public static boolean checkQueen(int row, int col) {
        int oriRow = row;
        int oriCol = col;

        // 왼쪽 대각선 위 확인
        while (row - 1 >= 0 && col - 1 >= 0) {
            row -= 1;
            col -= 1;
            if (board[row][col] == 1) return false;
        }

        row = oriRow;
        col = oriCol;
        // 오른쪽 대각선 위 확인
        while (row - 1 >= 0 && col + 1 < N) {
            row -= 1;
            col += 1;
            if (board[row][col] == 1) return false;
        }

        return true;
    }


}
