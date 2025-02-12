import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int l = i == 0 ? 1 : 0;
            int r = i == N - 1 ? N - 2 : N - 1;

            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    answer++;
                    break;
                } else if (arr[l] + arr[r] > arr[i]) {
                    r--;
                    if (r == i) r--;
                } else {
                    l++;
                    if (l == i) l++;
                }
            }
        }

        System.out.println(answer);
    }
}