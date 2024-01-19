import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);
        int temp_max = 0;

        map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(sa[j]);
                if(temp_max < map[i][j]) temp_max = map[i][j];
            }
        }

        for(int k=0; k<temp_max; k++){
            visited = new boolean[N][N];
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && map[i][j] > k){
                        bfs(i, j, k);
                        count++;
                    }
                }
            }
            if(count > max) max = count;
        }

        System.out.println(max);

    }

    public static void bfs(int y, int x, int target){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y, x});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = y + dy[i];
                int ndx = x + dx[i];
                if(ndy >= 0 && ndx >= 0 && ndy < N && ndx < N){
                    if(!visited[ndy][ndx] && map[ndy][ndx] > target){
                        q.add(new int[]{ndy, ndx});
                        visited[ndy][ndx] = true;
                    }
                }
            }
        }
    }
}