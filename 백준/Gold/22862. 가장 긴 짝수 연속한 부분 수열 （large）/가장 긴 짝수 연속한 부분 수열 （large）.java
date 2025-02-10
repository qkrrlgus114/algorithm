import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int s = 0;
        int e = 0;
        int useK = 0;
        int length = 0;

        if (arr[e] % 2 != 0) {
            useK++;
        } else {
            length = 1;
        }

        while (e < N - 1) {
            e++;

            // 짝수면
            if (arr[e] % 2 == 0) {
                length = Math.max(length, e - s - useK + 1);
            }
            // 홀수면
            else {
                if (useK == K) {
                    while (true) {
                        if (arr[s] % 2 != 0) {
                            s++;
                            break;
                        }
                        s++;
                    }
                } else {
                    useK++;
                }
            }
        }

        System.out.println(length);
    }
}