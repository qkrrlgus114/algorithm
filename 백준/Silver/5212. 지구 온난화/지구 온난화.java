import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int R, C;
    static char[][] origin;
    static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        R = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);

        origin = new char[R][C];
        result = new char[R][C];

        for (int i = 0; i < R; i++) {
            origin[i] = bf.readLine().toCharArray();
        }
        for (int i = 0; i < R; i++) {
            result[i] = Arrays.copyOf(origin[i], origin[i].length);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                checkAndChange(i, j);
            }
        }

        int startY = 100;
        int startX = 100;
        int endY = -1;
        int endX = -1;

        // 직사각형으로 범위를 잘라야 함
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (result[i][j] != 'X') continue;

                if (startY > i) {
                    startY = i;
                }
                if (startX > j) {
                    startX = j;
                }
                if (endY < i) {
                    endY = i;
                }
                if (endX < j) {
                    endX = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    // 인근 바다의 개수를 확인해서 바다로 변환하는 메서드
    private static void checkAndChange(int y, int x) {
        // 주변 바다의 개수
        int cnt = 0;

        // 상 하 좌 우 판단
        if (y - 1 < 0 || origin[y - 1][x] == '.') {
            cnt++;
        }

        if (y + 1 >= R || origin[y + 1][x] == '.') {
            cnt++;
        }

        if (x - 1 < 0 || origin[y][x - 1] == '.') {
            cnt++;
        }

        if (x + 1 >= C || origin[y][x + 1] == '.') {
            cnt++;
        }

        if (cnt >= 3) {
            result[y][x] = '.';
        }
    }


}