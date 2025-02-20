import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] arr = new int[M];
        long e = 0;
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            e = Math.max(e, arr[i]);
        }

        long s = 1;
        long answer = Long.MAX_VALUE;

        while (s <= e) {
            long m = (s + e) / 2;

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if (arr[i] % m == 0) {
                    cnt += arr[i] / m;
                } else {
                    cnt += (arr[i] / m) + 1;
                }
            }
            if (cnt <= N) {
                answer = Math.min(answer, m);
                e = m - 1;
            } else {
                s = m + 1;
            }

        }

        System.out.println(answer);
    }


}
