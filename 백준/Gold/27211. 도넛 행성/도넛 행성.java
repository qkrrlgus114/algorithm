import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;
    static int N;
    static int M;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    bfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(int y, int x){
        q = new LinkedList<>();
        q.add(new int[]{y, x});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = y + dy[i];
                int ndx = x + dx[i];
                // 정상적인 범위 내라면
                if(ndy >= 0 && ndx >= 0 && ndy < N && ndx < M){
                    check(ndy, ndx);
                }else if(ndy < 0){
                    ndy = N - 1;
                    check(ndy, ndx);
                }else if(ndx < 0){
                    ndx = M -1;
                    check(ndy, ndx);
                }else if(ndy == N){
                    ndy = 0;
                    check(ndy, ndx);
                }else if(ndx == M){
                    ndx = 0;
                    check(ndy, ndx);
                }
            }
        }
    }

    public static void check(int ndy, int ndx){
        if(map[ndy][ndx] == 0 && !visited[ndy][ndx]){
            map[ndy][ndx] = 1;
            visited[ndy][ndx] = true;
            q.add(new int[]{ndy, ndx});
        }
    }

}