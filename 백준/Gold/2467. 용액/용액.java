import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int result = Integer.MAX_VALUE;

        int l = 0;
        int r = N - 1;
        int result1 = 0;
        int result2 = 0;

        while (l < r) {
            int sum = arr[l] + arr[r];

            // 0에 가까운지 체크
            if (result > Math.abs(sum)) {
                result1 = arr[l];
                result2 = arr[r];
                result = Math.abs(sum);
            }

            if (sum == 0) break;

            if (sum > 0) {
                r--;
            } else {
                l++;
            }

        }

        System.out.println(result1 + " " + result2);
    }
}