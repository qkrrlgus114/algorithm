import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] graph;
    static boolean[][][] visited;
    static int result = 0;
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        K = Integer.parseInt(sa[2]);

        graph = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        bfs(0, 0);
        if(N == 1 && M == 1) System.out.println(1);
        else if(result == 0) System.out.println(-1);
        else System.out.println(result);
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, K, 1});
        visited[y][x][K] = true;

        outer: while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int wall = temp[2];
            int step = temp[3];
            for(int t=0; t<4; t++){
                int ndx = dx[t] + x;
                int ndy = dy[t] + y;
                // 도착했다면
                if(ndy == N - 1 && ndx == M - 1){
                    result = step + 1;
                    break outer;
                }
                // 범위체크
                if(ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
                // 현재가 벽인데 더이상 못부수면
                if(graph[ndy][ndx] == 1 && wall == 0) continue;
                // 이 조건에서는 벽 부수고 이동
                if(graph[ndy][ndx] == 1 && wall != 0 && !visited[ndy][ndx][wall]){
                    boolean check = false;
                    for(int i=K; i>=wall; i--){
                        if(visited[ndy][ndx][i]){
                            check = true;
                            break;
                        }
                    }
                    if(!check){
                        visited[ndy][ndx][wall] = true;
                        q.add(new int[]{ndy, ndx, wall - 1, step + 1});
                    }
                }else if(graph[ndy][ndx] == 0 && !visited[ndy][ndx][wall]){
                    visited[ndy][ndx][wall] = true;
                    q.add(new int[]{ndy, ndx, wall, step + 1});
                }

            }
        }
    }
}

