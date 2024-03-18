import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int N, M;
    static char[][] graph;
    static boolean[] visited = new boolean[28];
    static int result = Integer.MIN_VALUE;
    // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        graph = new char[N][M];
        for(int i=0; i<N; i++){
            graph[i] = bf.readLine().toCharArray();
        }

        visited[graph[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int y, int x, int step){

        for(int i=0; i<4; i++){
            int ndy = y + dy[i];
            int ndx = x + dx[i];
            if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
            if(visited[graph[ndy][ndx] - 'A']) continue;
            visited[graph[ndy][ndx] - 'A'] = true;
            dfs(ndy, ndx, step + 1);
            visited[graph[ndy][ndx] - 'A'] = false;
        }

        result = Math.max(result, step);
    }


}