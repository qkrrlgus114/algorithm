import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static int answer = 0;
    // 상 우 하 좌
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        /*
        * 제일 큰 음식물만 피해가려고 함
        *
        * */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);

        graph = new int[N][M];

        for(int i=0; i<K; i++){
            str = bf.readLine().split(" ");
            int start = Integer.parseInt(str[0]) - 1;
            int end = Integer.parseInt(str[1]) - 1;

            graph[start][end] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if (graph[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        int count = 1;
        graph[y][x] = 0;

        while(q.size() != 0){
            int[] temp = q.poll();
            int temp_y = temp[0];
            int temp_x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = temp_y + dy[i];
                int ndx = temp_x + dx[i];
                if(ndy >= 0 && ndx >= 0 && ndy < N && ndx < M) {
                    if (graph[ndy][ndx] == 1) {
                        q.add(new int[]{ndy, ndx});
                        count++;
                        graph[ndy][ndx] = 0;
                    }
                }
            }
        }

        if (answer < count){
            answer = count;
        }
    }
}