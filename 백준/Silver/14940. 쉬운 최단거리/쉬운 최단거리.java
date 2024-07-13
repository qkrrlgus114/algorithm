import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N, M;
    static boolean[][] visited;
    static int[][] arr;
    static int[][] result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        arr = new int[N][M];
        visited = new boolean[N][M];
        result = new int[N][M];

        int y = 0;
        int x = 0;

        for(int i=0; i<N; i++){
            Arrays.fill(result[i], -1);
        }

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(sa[j]);
                if(arr[i][j] == 2){
                    y = i;
                    x = j;
                }else if(arr[i][j] == 0){
                    result[i][j] = arr[i][j];
                }
            }
        }

        bfs(y, x);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y, x, 0});
        result[y][x] = 0;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int dis = temp[2];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if(visited[ny][nx] || arr[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                result[ny][nx] = dis + 1;
                q.add(new int[]{ny, nx, dis + 1});
            }
        }
    }
}