import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = 0;
        int cnt = 1;
        while (r < N - 1) {
            r++;
            if (arr[r] - arr[l] < 5) {
                cnt = Math.max(cnt, r - l + 1);
            } else {
                l++;
            }
        }

        System.out.println(5 - cnt);
    }
}