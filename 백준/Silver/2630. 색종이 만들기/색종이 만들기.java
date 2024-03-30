import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    1 : 하얀색, 0 : 검은색
    * 1X1 -> 1 : 34, 0 : 30
    * 2x2 -> 1 : 8 - 4 + 1, 0 : 7
    * 4x4 -> 1 : 1, 0 : 0
    * 8x8 -> 1 : 0, 0 : 0
    */

    static int N;
    static int[][] graph;
    static int white, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }

        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int y, int x, int size) {
        if (check(y, x, size)) {
            if (graph[y][x] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        size = size / 2;

        partition(y, x, size);
        partition(y + size, x, size);
        partition(y, x + size, size);
        partition(y + size, x + size, size);
    }


    // 색종이 확인
    public static boolean check(int y, int x, int size) {
        int init = graph[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (init != graph[i][j]) return false;
            }
        }

        return true;
    }
}



