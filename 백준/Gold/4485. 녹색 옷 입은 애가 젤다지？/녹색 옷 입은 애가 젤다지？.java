import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int result;
    static int[][] arr;
    static int[][] visited;
    static int N;

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;

        while(true){
            N = Integer.parseInt(bf.readLine());
            if(N == 0 ) break;

            arr = new int[N][N];
            visited = new int[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }
            result = Integer.MAX_VALUE;

            for(int i=0; i<N; i++){
                String[] sa = bf.readLine().split(" ");
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(sa[j]);
                }
            }

            bfs(0, 0);

            sb.append("Problem ").append(count++).append(": ").append(visited[N-1][N-1]).append("\n");
        }

        System.out.println(sb);


    }

    private static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, arr[y][x]});
        visited[y][x] = arr[y][x];

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int count = temp[2];

            if(y == N-1 && x == N-1) continue;

            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;

                if(ndx < 0 || ndy < 0 || ndx >= N || ndy >= N) continue;
                if(visited[ndy][ndx] <= count + arr[ndy][ndx]) continue;

                visited[ndy][ndx] = count + arr[ndy][ndx];
                q.add(new int[]{ndy, ndx, visited[ndy][ndx]});
            }
        }

    }
}

