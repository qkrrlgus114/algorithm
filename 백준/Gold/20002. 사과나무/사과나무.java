import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int answer = Integer.MIN_VALUE;
    static int[][] arr;
    static int[][] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1][N + 1];
        prefix = new int[N + 1][N + 1];

        // 입력
        for (int i = 1; i <= N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(sa[j - 1]);
            }
        }

        // 누적합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + arr[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            appleCheck(i);
        }

        System.out.println(answer);

    }

    private static void appleCheck(int x) {
        for (int i = 1; i <= N - x + 1; i++) {
            for (int j = 1; j <= N - x + 1; j++) {
                int num = prefix[i + x - 1][j + x - 1] - prefix[i - 1][j + x - 1] - prefix[i + x - 1][j - 1] + prefix[i - 1][j - 1];
                answer = Math.max(answer, num);
            }
        }
    }

}