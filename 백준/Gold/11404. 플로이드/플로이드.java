import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int M = Integer.parseInt(bf.readLine());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= N; i++) {
            arr[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String[] sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            int value = Integer.parseInt(sa[2]);


            arr[start][end] = Math.min(arr[start][end], value);
        }


        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (arr[s][m] != Integer.MAX_VALUE && arr[m][e] != Integer.MAX_VALUE) {
                        arr[s][e] = Math.min(arr[s][e], arr[s][m] + arr[m][e]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(arr[i][j] == Integer.MAX_VALUE ? 0 : arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }


}
