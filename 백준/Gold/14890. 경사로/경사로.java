import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;
    static int N, L;
    static int[][] fixRowLoad;
    static int[][] fixColLoad;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        L = Integer.parseInt(sa[1]);

        int[][] arr = new int[N][N];
        fixRowLoad = new int[N][N];
        fixColLoad = new int[N][N];
        boolean[] isRowCross = new boolean[N];
        boolean[] isColCross = new boolean[N];
        Arrays.fill(isColCross, true);
        Arrays.fill(isRowCross, true);

        int[][] colArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                colArr[j][i] = arr[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            if (rowCheck(arr[i], true, i, true)) {
                if (rowCheck(arr[i], false, i, true)) {
                    for (int j = 0; j < N; j++) {
                        if (fixRowLoad[i][j] >= 2) {
                            isRowCross[i] = false;
                            break;
                        }
                    }
                    if (isRowCross[i]) {
                        result++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (rowCheck(colArr[i], true, i, false)) {
                if (rowCheck(colArr[i], false, i, false)) {
                    for (int j = 0; j < N; j++) {
                        if (fixColLoad[i][j] >= 2) {
                            isColCross[i] = false;
                            break;
                        }
                    }
                    if (isColCross[i]) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);


    }

    private static boolean rowCheck(int[] load, boolean dir, int row, boolean fixLoad) {
        int startIndex = 0;
        int count = 1;

        // dir = true면 왼쪽에서 오른쪽으로 이동
        if (dir) {
            for (int i = 0; i < N - 1; i++) {
                // 현재 L을 만족하고 다음 위치가 +1이면 놓을 수 있음
                if (count == L && load[i + 1] == load[i] + 1) {
                    for (int j = startIndex; j < startIndex + L; j++) {
                        if (fixLoad) fixRowLoad[row][j] += 1;
                        else fixColLoad[row][j] += 1;
                    }
                    startIndex = i + 1;
                    count = 1;

                }
                // 현재 L을 만족하고 다음 위치가 현재와 같으면
                else if (count == L && load[i + 1] == load[i]) {
                    startIndex++;
                } else if (count == L && load[i + 1] > load[i] + 1) {
                    return false;
                }
                // 현재 L을 만족하지 않고 다음 위치가 +1이면 못 건넘
                else if (count != L && load[i + 1] >= load[i] + 1) {
                    return false;
                }
                // 현재 L을 만족하지 않고 다음 위치가 현재와 같으면
                else if (count != L && load[i + 1] == load[i]) {
                    count++;
                } else if (load[i + 1] < load[i] || load[i + 1] > load[i]) {
                    count = 1;
                    startIndex = i + 1;
                }
            }
        }
        // dir = false면 오른쪽에서 왼쪽으로 이동
        else {
            startIndex = N - 1;
            for (int i = N - 1; i > 0; i--) {
                // 현재 L을 만족하고 다음 위치가 +1이면 놓을 수 있음
                if (count == L && load[i - 1] == load[i] + 1) {
                    for (int j = startIndex; j > startIndex - L; j--) {
                        if (fixLoad) fixRowLoad[row][j] += 1;
                        else fixColLoad[row][j] += 1;
                    }
                    startIndex = i - 1;
                    count = 1;
                }
                // 현재 L을 만족하고 다음 위치가 현재와 같으면
                else if (count == L && load[i - 1] == load[i]) {
                    startIndex--;
                } else if (count == L && load[i - 1] > load[i] + 1) {
                    return false;
                }
                // 현재 L을 만족하지 않고 다음 위치가 +1이면 못 건넘
                else if (count != L && load[i - 1] >= load[i] + 1) {
                    return false;
                }
                // 현재 L을 만족하지 않고 다음 위치가 현재와 같으면
                else if (count != L && load[i - 1] == load[i]) {
                    count++;
                } else if (load[i - 1] < load[i] || load[i - 1] > load[i]) {
                    count = 1;
                    startIndex = i - 1;
                }
            }
        }

        return true;
    }
}
