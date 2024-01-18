import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    // 방문체크
    static boolean[][] visited;
    // 정답
    static int result = 0;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        dp[N-1][M-1] = 1;
        visited[0][0] = true;
        dfs(0, 0, map[0][0]);
        System.out.println(dp[0][0]);

    }

    public static void dfs(int y, int x, int value){
        if(y == N-1 && x == M-1){
            return;
        }

        visited[y][x] = true;

        for(int i=0; i<4; i++){
            int ndy = y + dy[i];
            int ndx = x + dx[i];
            if(ndy >= 0 && ndx >= 0 && ndy < N && ndx < M){
                if(map[ndy][ndx] < value){
                    if(visited[ndy][ndx]){
                        dp[y][x] += dp[ndy][ndx];
                    }else{
                        dfs(ndy, ndx, map[ndy][ndx]);
                        dp[y][x] += dp[ndy][ndx];
                    }
                }
            }
        }
    }
}