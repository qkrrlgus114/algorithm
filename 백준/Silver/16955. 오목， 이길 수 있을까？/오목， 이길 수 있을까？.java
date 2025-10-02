import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = bf.readLine().toCharArray();
        }

        boolean success = false;

        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] != '.') continue;

                int mi = i - 1;
                // 상하
                int cnt = 1;
                while (mi >= 0) {
                    if (board[mi--][j] == 'X') cnt++;
                    else break;
                }
                mi = i + 1;
                while (mi < 10) {
                    if (board[mi++][j] == 'X') cnt++;
                    else break;
                }
                if (cnt >= 5) {
                    success = true;
                    break outer;
                }

                // 좌우
                int mj = j - 1;
                cnt = 1;
                while (mj >= 0) {
                    if (board[i][mj--] == 'X') cnt++;
                    else break;
                }
                mj = j + 1;
                while (mj < 10) {
                    if (board[i][mj++] == 'X') cnt++;
                    else break;
                }
                if (cnt >= 5) {
                    success = true;
                    break outer;
                }

                // 좌상우하
                mi = i - 1;
                mj = j - 1;
                cnt = 1;
                while (mj >= 0 && mi >= 0) {
                    if (board[mi--][mj--] == 'X') cnt++;
                    else break;
                }
                mi = i + 1;
                mj = j + 1;
                while (mj < 10 && mi < 10) {
                    if (board[mi++][mj++] == 'X') cnt++;
                    else break;
                }
                if (cnt >= 5) {
                    success = true;
                    break outer;
                }

                // 우상좌하
                mi = i - 1;
                mj = j + 1;
                cnt = 1;
                while (mj < 10 && mi >= 0) {
                    if (board[mi--][mj++] == 'X') cnt++;
                    else break;
                }
                mi = i + 1;
                mj = j - 1;
                while (mj >= 0 && mi < 10) {
                    if (board[mi++][mj--] == 'X') cnt++;
                    else break;
                }
                if (cnt >= 5) {
                    success = true;
                    break outer;
                }
            }
        }

        System.out.println(success ? "1" : "0");

    }

}
