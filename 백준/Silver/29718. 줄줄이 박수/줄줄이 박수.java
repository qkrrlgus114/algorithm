import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        // 누적 박수 열
        int[] prefix = new int[M];
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
                prefix[j] += arr[i][j];
            }
        }

        int A = Integer.parseInt(bf.readLine());

        long sum = 0;
        long answer = 0;
        for (int i = 0; i < A; i++) {
            sum += prefix[i];
        }
        answer = Math.max(answer, sum);

        // 슬라이딩 윈도우
        for (int i = A; i < M; i++) {
            sum += prefix[i];
            sum -= prefix[i - A];

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }

}