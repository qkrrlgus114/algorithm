import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int useK = 0;

        int[] arr = new int[N];

        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int l = 0;
        int r = 0;
        int length = 0;

        if (arr[r] % 2 == 0) {
            length++;
        } else {
            useK++;
        }

        while (r < N - 1) {
            r++;
            if (arr[r] % 2 == 0) {
                length = Math.max(length, r - l - useK + 1);
            } else {
                // 아직 K가 있으면 K 사용
                if (useK < K) {
                    useK++;
                    continue;
                }

                while (true) {
                    // l의 위치가 홀수면
                    if (arr[l] % 2 != 0) {
                        l++;
                        break;
                    }
                    l++;
                }

            }
        }

        System.out.println(length);


    }
}