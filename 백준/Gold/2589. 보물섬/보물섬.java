import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            arr[i] = s.toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 'W') continue;
                clearVisited();
                bfs(i, j);
            }
        }

        System.out.println(answer);


    }

    private static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            y = poll[0];
            x = poll[1];
            int count = poll[2];
            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(arr[ndy][ndx] == 'W' || visited[ndy][ndx]) continue;
                visited[ndy][ndx] = true;
                q.add(new int[]{ndy, ndx, count + 1});
                answer = Math.max(answer, count + 1);
            }
        }
    }

    private static void clearVisited(){
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], false);
        }
    }

}


