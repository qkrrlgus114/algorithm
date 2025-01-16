import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = bf.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                arr[i][j] = c[j] - '0';
            }
        }

        int result = 1;
        int size = 2;

        while (true) {
            if (size > N || size > M) break;

            outer:
            for (int i = 0; i < N - size + 1; i++) {
                for (int j = 0; j < M - size + 1; j++) {
                    if (arr[i][j] == arr[i][j + size - 1] && arr[i][j] == arr[i + size - 1][j] && arr[i][j] == arr[i + size - 1][j + size - 1]) {
                        result = size * size;
                        break outer;
                    }
                }
            }

            size++;
        }

        System.out.println(result);
    }


}