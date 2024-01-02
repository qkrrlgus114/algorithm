import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int W;
    static int H;
    static int[][] map;
    static int[][] result;
    static Queue<int[]> q = new LinkedList<>();
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        W = Integer.parseInt(s[0]);
        H = Integer.parseInt(s[1]);

        map = new int[H][W];
        result = new int[H][W];

        for (int i = 0; i < H; i++) {
            s = bf.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if(Integer.parseInt(s[j]) == -1) result[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 1) {
                    result[i][j] = -1;
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        bfs();

        int zeroCount = 0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(result[i][j] == 0){
                    zeroCount++;
                }
            }
        }

        if(zeroCount != 0) System.out.println(-1);
        else System.out.println(max);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int count = temp[2];
            for (int a = 0; a < 4; a++) {
                int ndx = x + dx[a];
                int ndy = y + dy[a];
                if (ndx >= 0 && ndy >= 0 && ndx < W && ndy < H) {
                    if (map[ndy][ndx] == 0 && result[ndy][ndx] == 0) {
                        q.add(new int[]{ndy, ndx, count + 1});
                        if(max < count + 1) max = count + 1;
                        map[ndy][ndx] = 1;
                        result[ndy][ndx] = count + 1;
                    }
                }
            }
        }
    }


}