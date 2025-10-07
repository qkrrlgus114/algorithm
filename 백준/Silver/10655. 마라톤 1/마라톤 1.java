import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");

            arr[i][0] = Integer.parseInt(sa[0]);
            arr[i][1] = Integer.parseInt(sa[1]);
        }


        int index = 0; // 건너 뛰어야 하는 인덱스
        long value = 0; // 거리 차이의 최댓값

        for (int i = 2; i < N; i++) {
            long beforeDist = circulator(arr[i][0], arr[i - 1][0], arr[i][1], arr[i - 1][1])
                    + circulator(arr[i - 1][0], arr[i - 2][0], arr[i - 1][1], arr[i - 2][1]);
            long afterDist = circulator(arr[i][0], arr[i - 2][0], arr[i][1], arr[i - 2][1]);

            if (beforeDist - afterDist > value) {
                value = beforeDist - afterDist;
                index = i - 1;
            }
        }

        long minDist = 0;

        for (int i = 1; i < N; i++) {
            if (index == i) {
                minDist += circulator(arr[i + 1][0], arr[i - 1][0], arr[i + 1][1], arr[i - 1][1]);
                i++;
            } else {
                minDist += circulator(arr[i][0], arr[i - 1][0], arr[i][1], arr[i - 1][1]);
            }
        }

        System.out.println(minDist);
    }

    // 맨해튼 거리 계산
    public static long circulator(int y1, int y2, int x1, int x2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}