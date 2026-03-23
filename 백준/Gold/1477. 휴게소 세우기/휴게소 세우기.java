import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        L = Integer.parseInt(sa[2]);

        int[] ori = new int[N + 2];
        sa = bf.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            ori[i] = Integer.parseInt(sa[i - 1]);
        }
        ori[0] = 0;
        ori[N + 1] = L;
        Arrays.sort(ori);

        int[] diff = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            diff[i] = ori[i + 1] - ori[i];
        }

        int answer = Integer.MAX_VALUE;
        int s = 1;
        int e = L;
        while (s <= e) {
            int m = (s + e) / 2;
            int sum = 0;
            for (int i = 0; i <= N; i++) {
                sum += (diff[i] - 1) / m;
            }
            if (sum <= M) {
                e = m - 1;
                answer = Math.min(answer, m);
            } else {
                s = m + 1;
            }
        }

        System.out.println(answer);
    }

}