import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int[] arr = new int[N];
            String[] sa = bf.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(sa[i]) + 100000000;
            }

            Arrays.sort(arr);

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    // j - i의 값
                    int diff = arr[j] - arr[i];
                    if (binarySearch(diff, j, N, arr)) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static boolean binarySearch(int diff, int j, int N, int[] arr) {
        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            if (diff == arr[m] - arr[j]) return true;
            else if (diff > arr[m] - arr[j]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return false;
    }


}
