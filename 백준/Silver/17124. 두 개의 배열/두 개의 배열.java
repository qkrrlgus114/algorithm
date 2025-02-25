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

            long sum = 0;

            for (int i = 0; i < n; i++) {

                int s = 0;
                int e = m - 1;
                // 차이
                int diff = Integer.MAX_VALUE;
                // C[i]에 들어갈 값
                int result = Integer.MAX_VALUE;

                while (s <= e) {
                    int mid = (s + e) / 2;

                    int value = B[mid];

                    if (Math.abs(value - A[i]) == 0) {
                        result = value;
                        break;
                    } else {
                        if (diff >= Math.abs(value - A[i])) {
                            if (diff == Math.abs(value - A[i])) {
                                diff = Math.abs(value - A[i]);
                                result = Math.min(result, value);
                            } else {
                                diff = Math.abs(value - A[i]);
                                result = value;
                            }

                        }

                        if (A[i] > value) {
                            s = mid + 1;
                        } else {
                            e = mid - 1;
                        }
                    }
                }
                
                sum += result;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}

