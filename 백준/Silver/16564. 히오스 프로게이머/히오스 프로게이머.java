import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        long s = 1;
        long e = 2000000000;
        long answer = 0;
        while (s <= e) {
            long m = (s + e) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] >= m) continue;
                sum += m - arr[i];
            }

            if (sum <= K) {
                answer = Math.max(answer, m);
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.println(answer);
    }

}