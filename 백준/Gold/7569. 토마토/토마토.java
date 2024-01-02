import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int W;
    static int N;
    static int H;
    static int[][][] map;
    static int[][][] result;
    static Queue<int[]> q = new LinkedList<>();
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dk = {-1, 1};
    static int max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        W = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);

        map = new int[H][N][W];
        result = new int[H][N][W];

        for(int k=0; k<H; k++){
            for (int i = 0; i < N; i++) {
                s = bf.readLine().split(" ");
                for (int j = 0; j < W; j++) {
                    map[k][i][j] = Integer.parseInt(s[j]);
                    if(Integer.parseInt(s[j]) == -1) result[k][i][j] = Integer.parseInt(s[j]);
                }
            }
        }

        for(int k=0; k<H; k++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[k][i][j] == 1) {
                        result[k][i][j] = -1;
                        q.add(new int[]{k, i, j, 0});
                    }
                }
            }
        }

        bfs();

        int zeroCount = 0;
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<W; j++){
                    if(result[k][i][j] == 0){
                        zeroCount++;
                    }
                }
            }
        }

        if(zeroCount != 0) System.out.println(-1);
        else System.out.println(max);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int k = temp[0];
            int y = temp[1];
            int x = temp[2];
            int count = temp[3];
            for (int a = 0; a < 4; a++) {
                int ndx = x + dx[a];
                int ndy = y + dy[a];
                if (ndx >= 0 && ndy >= 0 && ndx < W && ndy < N) {
                    if (map[k][ndy][ndx] == 0 && result[k][ndy][ndx] == 0) {
                        q.add(new int[]{k, ndy, ndx, count + 1});
                        if(max < count + 1) max = count + 1;
                        map[k][ndy][ndx] = 1;
                        result[k][ndy][ndx] = count + 1;
                    }
                }
            }
            for(int a=0; a<2; a++){
                int ndk = k + dk[a];
                if(ndk >=0 && ndk < H){
                    if(map[ndk][y][x] == 0 && result[ndk][y][x] == 0){
                        q.add(new int[]{ndk, y, x, count+1});
                        if(max < count + 1) max = count + 1;
                        map[ndk][y][x] = 1;
                        result[ndk][y][x] = count + 1;
                    }
                }
            }
        }
    }


}