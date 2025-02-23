import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        long s = 1;
        // 최대 시간을 가지는 심사대에서 전체 인원을 검사하는 경우를 최대로 잡음
        // (심사대가 하나일 수도 있으니)
        long e = (long) M * arr[N - 1];
        long result = Long.MAX_VALUE;

        while (s <= e) {
            long m = (s + e) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                // 한 심사대에서 커버 가능한 인원의 수
                long value = m / arr[i];

                sum += value;

                // sum을 더할 때 M 이상이면 break 해줘야 한다.
                // 안 그러면 오버플로우 발생함.
                if (sum >= M) break;
            }

            // M명 이상을 수용 가능하다면 최소값을 갱신
            if (sum >= M) {
                result = Math.min(result, m);
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        System.out.println(result);

    }
}