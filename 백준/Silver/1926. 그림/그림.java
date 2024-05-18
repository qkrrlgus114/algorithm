import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    // 그림의 최대 넓이
    static int maxWidth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];

        // 그림의 개수
        int count = 0;

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] || arr[i][j] == 0) continue;
                bfs(i, j);
                count++;
            }
        }

        System.out.println(count);
        System.out.println(maxWidth);

    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        int count = 1;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;
                // 범위, 방문여부 체크
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(visited[ndy][ndx] || arr[ndy][ndx] == 0) continue;

                count++;
                visited[ndy][ndx] = true;
                q.add(new int[]{ndy, ndx});
            }
        }

        maxWidth = Math.max(maxWidth, count);
    }

}

