import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int S = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int answer = Integer.MAX_VALUE;
        int s = 0;
        int e = -1;
        int sum = 0;

        while (e < N - 1) {
            e++;
            sum += arr[e];
            if (sum >= S) {
                answer = Math.min(answer, e - s + 1);
                while (sum >= S) {
                    answer = Math.min(answer, e - s + 1);
                    sum -= arr[s];
                    s++;
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}