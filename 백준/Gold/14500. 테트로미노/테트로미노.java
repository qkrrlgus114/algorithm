import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }


        // ㅗ 모양 제외하고 전부 확인
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, graph[i][j]);
                visited[i][j] = false;
            }
        }

        // ㅗ 모양 확인
        check();
        System.out.println(max);

    }

    public static void dfs(int y, int x ,int count, int sum){
        // 종료 조건
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 재귀
        for(int i=0; i<4; i++){
            int ndy = y + dy[i];
            int ndx = x + dx[i];
            if(ndx >= 0 && ndy >= 0 && ndx < M && ndy < N){
                if(!visited[ndy][ndx]){
                    visited[ndy][ndx] = true;
                    dfs(ndy, ndx, count + 1, sum + graph[ndy][ndx]);
                    visited[ndy][ndx] = false;
                }
            }
        }
    }

    public static void check(){
        // ㅜ 확인
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M-2; j++){
                int a = graph[i][j];
                a += graph[i][j+1] + graph[i+1][j+1] + graph[i][j+2];
                max = Math.max(max, a);
            }
        }

        // ㅗ 확인
        for(int i=1; i<N; i++){
            for(int j=0; j<M-2; j++){
                int a = graph[i][j];
                a += graph[i-1][j+1] + graph[i][j+1] + graph[i][j+2];
                max = Math.max(max, a);
            }
        }

        // ㅏ 확인
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-1; j++){
                int a = graph[i][j];
                a += graph[i+1][j] + graph[i+2][j] + graph[i+1][j+1];
                max = Math.max(max, a);
            }
        }

        // ㅓ 확인
        for(int i=1; i<N-2; i++){
            for(int j=0; j<M-1; j++){
                int a = graph[i][j];
                a += graph[i-1][j+1] + graph[i][j+1] + graph[i+1][j+1];
                max = Math.max(max, a);
            }
        }

    }
}