import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int Q = Integer.parseInt(sa[1]);

        long[] arr = new long[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        sa = bf.readLine().split(" ");
        int[] change = new int[Q];
        for (int i = 0; i < Q; i++) {
            change[i] = Integer.parseInt(sa[i]);
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i % N] * arr[(i + 1) % N] * arr[(i + 2) % N] * arr[(i + 3) % N];
        }


        // i - 3 ~ i
        // i - 2 ~ i + 1
        // i - 1 ~ i + 2
        // i ~ i + 3
        // 4번 이후의 소부터 0번째를 보면 된다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int changeCow = change[i] - 1;

            long tempSum = 1;
            // i-3 ~ i
            for (int j = -3; j < 1; j++) {
                tempSum *= arr[((changeCow + j) + N) % N];
            }
            sum -= tempSum;
            sum += tempSum * -1;
            tempSum = 1;
            for (int j = -2; j < 2; j++) {
                tempSum *= arr[((changeCow + j) + N) % N];
            }
            sum -= tempSum;
            sum += tempSum * -1;
            tempSum = 1;
            for (int j = -1; j < 3; j++) {
                tempSum *= arr[((changeCow + j) + N) % N];
            }
            sum -= tempSum;
            sum += tempSum * -1;
            tempSum = 1;
            for (int j = 0; j < 4; j++) {
                tempSum *= arr[((changeCow + j) + N) % N];
            }
            sum -= tempSum;
            sum += tempSum * -1;
            arr[changeCow] *= -1;
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }

}


