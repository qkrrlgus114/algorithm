import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] arr1;
    static char[][] arr2;

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        arr1 = new char[N][N];
        arr2 = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] chr = bf.readLine().toCharArray();

            arr1[i] = chr.clone();
            arr2[i] = chr.clone();
        }

        int result1 = 0;
        int result2 = 0;

        // 적록색약 bfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr1[i][j] != 'Q') {
                    result1++;
                    nonRGBFS(i, j);
                }
            }
        }

        // 일반 bfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr2[i][j] != 'Q') {
                    result2++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(result2 + " " + result1);

    }

    // 적록색약 bfs
    public static void nonRGBFS(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int ny = arr[0];
            int nx = arr[1];
            char cur = arr1[ny][nx];
            arr1[ny][nx] = 'Q';

            for (int i = 0; i < 4; i++) {
                int ndx = nx + dx[i];
                int ndy = ny + dy[i];

                if (ndx < 0 || ndy < 0 || ndx >= N || ndy >= N || arr1[ndy][ndx] == 'Q') continue;
                if (cur == 'R' || cur == 'G') {
                    if (arr1[ndy][ndx] == 'B') continue;
                } else if (cur != arr1[ndy][ndx]) {
                    continue;
                }

                q.add(new int[]{ndy, ndx});
            }
        }
    }

    // 일반 bfs
    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int ny = arr[0];
            int nx = arr[1];
            char cur = arr2[ny][nx];
            arr2[ny][nx] = 'Q';

            for (int i = 0; i < 4; i++) {
                int ndx = nx + dx[i];
                int ndy = ny + dy[i];

                if (ndx < 0 || ndy < 0 || ndx >= N || ndy >= N || arr2[ndy][ndx] == 'Q') continue;
                if (cur != arr2[ndy][ndx]) continue;

                q.add(new int[]{ndy, ndx});
            }
        }
    }

}
