import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int S = Integer.parseInt(sa[0]);
        int C = Integer.parseInt(sa[1]);

        // 파
        int[] arr = new int[S];
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }


        int s = 1;
        int e = 1_000_000_000;
        // 넣을 파의 길이
        int l = 0;
        while (s <= e) {
            int m = (s + e) / 2;

            long sum = 0;
            for (Integer a : arr) {
                sum += a / m;
            }

            if (sum >= C) {
                l = Math.max(l, m);
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        // 파닭에 넣을 파의 길이를 구했으니, 라면에 넣을 남은 파를 구해야함
        long answer = 0;
        // 현재까지 만든 파닭의 수
        long d = 0;
        for (Integer a : arr) {
            if (C < d + a / l) {
                a -= l;
                d++;
                if (d >= C) {
                    answer += a;
                    break;
                }
            } else {
                answer += a % l;
                d += a / l;
            }
        }

        System.out.println(answer);
    }
}