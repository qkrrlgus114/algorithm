import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int maxHeight = 0;
        int leftMaxHeightIdx = 0;
        int rightMaxHeightIdx = 0;

        int[] arr = new int[1001];
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            int L = Integer.parseInt(sa[0]);
            int H = Integer.parseInt(sa[1]);

            arr[L] = H;

            // 가장 높은 높이와 그 높이의 왼쪽, 오른쪽 인덱스를 갱신해 나간다.
            if (maxHeight < H) {
                maxHeight = H;
                leftMaxHeightIdx = L;
                rightMaxHeightIdx = L;
            } else if (maxHeight == H) {
                leftMaxHeightIdx = Math.min(leftMaxHeightIdx, L);
                rightMaxHeightIdx = Math.max(rightMaxHeightIdx, L);
            }
        }

        // 왼쪽 누적합, 오른쪽 누적합
        int[] leftPrefix = new int[1001];
        int[] rightPrefix = new int[1002];

        for (int i = 1; i <= 1000; i++) {
            leftPrefix[i] = Math.max(leftPrefix[i - 1], arr[i]);
        }
        for (int i = 1000; i >= 2; i--) {
            rightPrefix[i] = Math.max(rightPrefix[i + 1], arr[i]);
        }

        long answer = 0;
        for (int i = 0; i <= 1000; i++) {
            if (leftPrefix[i] == maxHeight) break;
            answer += leftPrefix[i];
        }
        for (int i = 1000; i >= 0; i--) {
            if (rightPrefix[i] == maxHeight) break;
            answer += rightPrefix[i];
        }
        for (int i = leftMaxHeightIdx; i <= rightMaxHeightIdx; i++) {
            answer += maxHeight;
        }

        System.out.println(answer);
    }
}