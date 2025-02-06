import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int l = 0;
        int r = N - 1;
        int cnt = 0;

        while (l < r) {
            if (arr[l] + arr[r] <= K) {
                cnt++;
                l++;
                r--;
            } else {
                r--;
            }
        }

        System.out.println(cnt);
    }
}