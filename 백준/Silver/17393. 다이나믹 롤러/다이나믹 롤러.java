import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        long[] A = new long[N];
        long[] B = new long[N];

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(sa[i]);
        }

        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(sa[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            long AInk = A[i];

            if (i == N - 1) {
                sb.append("0");
                break;
            }

            int s = i + 1;
            int e = N - 1;
            int index = N;
//            System.out.println("시작 : " + i);
            while (s <= e) {
                int m = (s + e) / 2;

                if (AInk >= B[m]) {
                    s = m + 1;
                } else {
//                    System.out.println("else : " + B[m]);
                    index = m;
                    e = m - 1;
                }
            }
//
//            System.out.println("index : " + index);
//            System.out.println("결과 : " + (index - i + 1));

            sb.append(index - 1 - i).append(" ");
        }

        System.out.println(sb);
    }
}

