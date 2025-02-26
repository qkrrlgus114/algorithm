import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int s = 0;
        int e = 0;

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
            e = Math.max(e, arr[i]);
        }

        int result = Integer.MAX_VALUE;

        // 구간 점수를 기준으로 잡고 이분 탐색
        while (s <= e) {
            int m = (s + e) / 2;

            if (calculatorM(m, N, arr) <= M) {
                result = Math.min(result, m);
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        System.out.println(result);

    }

    public static int calculatorM(int m, int n, int[] arr) {
        int result = 1;
        int min = 10001;
        int max = 0;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            // 최대 - 최소를 했을 때 m 초과라면 구간으로 나눠준다.(즉 카운트)
            if (max - min > m) {
                result++;
                max = 0;
                min = 10001;
                i--; // 초과했으니 이전 인덱스부터 다시 계산
            }
        }

        return result;
    }
}

