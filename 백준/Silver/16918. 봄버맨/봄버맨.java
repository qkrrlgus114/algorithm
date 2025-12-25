import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int R;
    static int C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        R = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);
        int N = Integer.parseInt(sa[2]);

        int[][] ground = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(ground[i], -1);
        }

        // 첫 폭탄 세팅
        for (int i = 0; i < R; i++) {
            char[] arr = bf.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (arr[j] == 'O') {
                    ground[i][j] = 0;
                }
            }
        }

        int second = 2;
        // 폭탄 설치 플래그
        boolean flag = true;

        for (int t = 2; t <= N; t++) {
            // 폭탄 설치;
            if (flag) {
                boomSet(ground, second);
            } else {
                boom(ground, second);
            }
            second++;
            flag = !flag;
        }

        char[][] result = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (ground[i][j] == -1) {
                    result[i][j] = '.';
                } else {
                    result[i][j] = 'O';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void boomSet(int[][] ground, int second) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (ground[i][j] == -1) {
                    ground[i][j] = second;
                }
            }
        }
    }

    private static void boom(int[][] ground, int second) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (ground[i][j] == second - 3) {
                    for (int d = 0; d < 4; d++) {
                        int ndx = dx[d] + j;
                        int ndy = dy[d] + i;
                        if (ndx < 0 || ndy < 0 || ndx >= C || ndy >= R) continue;
                        // 상하좌우가 터져야 하는 폭탄이 아니면
                        if (ground[ndy][ndx] != ground[i][j]) ground[ndy][ndx] = -1;
                    }
                    ground[i][j] = -1;
                }
            }
        }
    }
}
