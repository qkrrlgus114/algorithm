import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 현재 행렬의 크기
    static int N;

    // 행렬
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N != 1) {
            polling();
        }

        System.out.println(board[0][0]);
    }

    // 풀링
    private static void polling() {
        // 두 번째로 큰 수의 모임
        List<Integer> pollingList = new ArrayList<>();

        for (int i = 0; i < N; i += 2) {
            for (int j = 0; j < N; j += 2) {
                List<Integer> list = new ArrayList<>(Arrays.asList(board[i][j], board[i + 1][j], board[i][j + 1], board[i + 1][j + 1]));
                Collections.sort(list, Collections.reverseOrder());
                // 두 번째로 큰 수를 집어넣는다.
                pollingList.add(list.get(1));
            }
        }

        N /= 2;
        board = new int[N][N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = pollingList.get(index++);
            }
        }
    }
}