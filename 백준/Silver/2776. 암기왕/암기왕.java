import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int[] A = new int[N];
            String[] sa = bf.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(sa[i]);
            }

            int M = Integer.parseInt(bf.readLine());
            int[] B = new int[M];
            sa = bf.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(sa[i]);
            }

            Arrays.sort(A);

            for (int i = 0; i < M; i++) {
                // 물어볼 값
                int value = B[i];

                int s = 0;
                int e = N - 1;
                boolean check = false;

                while (s <= e) {
                    int m = (s + e) / 2;

                    if (A[m] == value) {
                        check = true;
                        break;
                    } else if (A[m] > value) {
                        e = m - 1;
                    } else {
                        s = m + 1;
                    }
                }

                if (check) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}

