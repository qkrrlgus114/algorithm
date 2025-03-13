import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        // 행 누적합 배열
        int[] rowPrefix = new int[N];
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += arr[i][j];
            }
            rowPrefix[i] = sum;
        }

        // 열 누적합 배열
        int[] colPrefix = new int[M];
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[j][i];
            }
            colPrefix[i] = sum;
        }

        long answer = Long.MIN_VALUE;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = 0; k < M - 1; k++) {
                    for (int l = k + 1; l < M; l++) {
                        long sum = rowPrefix[i] + rowPrefix[j] + colPrefix[k] + colPrefix[l];
                        // 겹치는 부분은 빼준다
                        sum -= arr[i][k] + arr[i][l] + arr[j][k] + arr[j][l];
                        // 녹지의 개수도 더해줌
                        if (j - i > 1 && l - k > 1) {
                            sum += (j - i - 1) * (l - k - 1);
                            answer = Math.max(answer, sum);
                        } else {
                            answer = Math.max(answer, sum);
                        }
                    }
                }
            }
        }

        System.out.println(answer);


    }
}