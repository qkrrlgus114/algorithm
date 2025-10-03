import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[][] colors = new int[N + 1][N];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(colors[i], 10000);
        }
        int[] position = new int[N + 1];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            int color = Integer.parseInt(sa[1]);
            int index = position[color]; // 해당 색깔의 인덱스

            colors[color][index] = Integer.parseInt(sa[0]);
            position[color] += 1;
        }

        for (int i = 0; i < N + 1; i++) {
            Arrays.sort(colors[i]);
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < position[i]; j++) {
                // 왼쪽
                int left = 0;
                if (j != 0) {
                    left = colors[i][j] - colors[i][j - 1];
                }

                // 오른쪽
                int right = 0;
                if (j != position[i] - 1) {
                    right = colors[i][j + 1] - colors[i][j];
                }

                if (left == 0) {
                    answer += right;
                } else if (right == 0) {
                    answer += left;
                } else {
                    answer += Math.min(left, right);
                }
                
            }
        }

        System.out.println(answer);
    }

}
