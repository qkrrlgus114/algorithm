import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[101][101];

        int N = Integer.parseInt(bf.readLine());
        for (int t = 0; t < N; t++) {
            String[] sa = bf.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);

            for (int i = y; i < y + 10; i++) {
                for (int j = x; j < x + 10; j++) {
                    board[i][j] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (board[i][j] == 1) answer++;
            }
        }

        System.out.println(answer);
    }

}