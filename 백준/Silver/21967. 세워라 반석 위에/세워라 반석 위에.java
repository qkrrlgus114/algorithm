import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[11];

        int N = Integer.parseInt(bf.readLine());
        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int l = 0;
        int r = 0;
        int result = 0;
        int min = 10;
        int max = 1;

        while (r < N) {
            count[arr[r]]++;
            r++;
            for (int i = 10; i >= 1; i--) {
                if (count[i] != 0) {
                    max = i;
                    break;
                }
            }
            for (int i = 1; i <= 10; i++) {
                if (count[i] != 0) {
                    min = i;
                    break;
                }
            }

            if (max - min <= 2) {
                result++;
            } else {
                count[arr[l]]--;
                l++;
            }
        }

        System.out.println(result);
    }
}