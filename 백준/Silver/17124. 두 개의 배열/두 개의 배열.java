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
            String[] sa = bf.readLine().split(" ");
            int n = Integer.parseInt(sa[0]);
            int m = Integer.parseInt(sa[1]);

            int[] A = new int[n];
            int[] B = new int[m];

            sa = bf.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(sa[i]);
            }
            sa = bf.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(sa[i]);
            }
            Arrays.sort(B);

            int[] c = new int[n];
            for (int j = 0; j < n; j++) {
                int number = A[j];

                boolean check = false;
                int start = 0;
                int end = m - 1;
                while (start + 1 < end) {
                    int mid = (start + end) / 2;

                    if (number == B[mid]) {
                        check = true;
                        c[j] = number;
                        break;
                    } else if (number > B[mid]) {
                        start = mid;
                    } else if (number < B[mid]) {
                        end = mid;
                    }
                }
                if (!check) {
                    if (Math.abs(number - B[start]) == Math.abs(number - B[end])) {
                        c[j] = B[start];
                    } else if (Math.abs(number - B[start]) < Math.abs(number - B[end])) {
                        c[j] = B[start];
                    } else if (Math.abs(number - B[start]) > Math.abs(number - B[end])) {
                        c[j] = B[end];
                    }
                }
            }

            long result = 0;
            for (int j = 0; j < c.length; j++) {
                result += c[j];
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}

