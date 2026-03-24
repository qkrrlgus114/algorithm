import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        String[] sa = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int[] tails = new int[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            int x = arr[i];

            if (len == 0) {
                tails[0] = x;
                len++;
            } else {
                if (tails[len - 1] < x) {
                    tails[len] = x;
                    len++;
                } else {
                    // 이분탐색으로 어디에 넣어야 하는지 확인
                    int l = 0;
                    int r = len - 1;

                    while (l <= r) {
                        int m = (l + r) / 2;

                        if (tails[m] < x) {
                            l = m + 1;
                        } else {
                            r = m - 1;
                        }
                    }

                    tails[l] = x;
                }
            }
        }
        System.out.println(len);
    }


}