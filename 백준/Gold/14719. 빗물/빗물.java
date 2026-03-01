import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] ground;
    static int answer = 0;
    static int hIdx = 0; // 가장 높은 곳의 인덱스
    static int curIdx = 0;
    static int cur = 0;
    static int H = 0;
    static int W = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        H = Integer.parseInt(sa[0]);
        W = Integer.parseInt(sa[1]);

        ground = new int[W];
        sa = bf.readLine().split(" ");
        int highValue = 0;
        for (int i = 0; i < W; i++) {
            ground[i] = Integer.parseInt(sa[i]);
            if (highValue <= ground[i]) {
                highValue = ground[i];
                hIdx = i;
            }
        }

        // 왼쪽부터 hIdx까지 탐색
        cur = ground[0];
        for (int i = 1; i <= hIdx; i++) {
            if (cur <= ground[i]) {
                int diffSum = 0;
                for (int j = curIdx + 1; j < i; j++) {
                    diffSum += ground[j] - 1;
                }

                answer += ((cur - 1) * (i - curIdx - 1)) - diffSum;

                // 현재값 갱신
                cur = ground[i];
                curIdx = i;
            }
        }

        // 오른쪽부터 hIdx까지 탐색
        cur = ground[W - 1];
        curIdx = W - 1;
        for (int i = W - 2; i >= hIdx; i--) {
            if (cur <= ground[i]) {
                int diffSum = 0;
                for (int j = curIdx - 1; j > i; j--) {
                    diffSum += ground[j] - 1;
                }

                answer += ((cur - 1) * (curIdx - i - 1)) - diffSum;

                cur = ground[i];
                curIdx = i;
            }
        }

        System.out.println(answer);
    }


}