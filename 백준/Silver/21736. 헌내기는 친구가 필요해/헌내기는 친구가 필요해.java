import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;
    static boolean[][] visited;
    static int answer = 0;
    static int N, M;
    // 상하좌우
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
            arr[i] = bf.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 'I'){
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer != 0 ? answer : "TT");
    }

    private static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ny = dy[i] + y;
                int nx = dx[i] + x;
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(visited[ny][nx]) continue;
                if(arr[ny][nx] == 'X') continue;

                visited[ny][nx] = true;
                if(arr[ny][nx] == 'P') answer++;
                q.add(new int[]{ny, nx});
            }
        }
    }


}
