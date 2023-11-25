import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 10시부터 시작
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    // 총 횟수
    static int count = 0;
    static int y2 = 0;
    static int x2 = 0;
    static int size = 0;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(bf.readLine());

        for (int t = 0; t < tc; t++) {
            size = Integer.parseInt(bf.readLine());

            graph = new int[size][size];

            // 현재 위치
            String[] s = bf.readLine().split(" ");
            int y1 = Integer.parseInt(s[0]);
            int x1 = Integer.parseInt(s[1]);

            // 목표 지점
            s = bf.readLine().split(" ");
            y2 = Integer.parseInt(s[0]);
            x2 = Integer.parseInt(s[1]);

            graph[y1][x1] = 1;

            int result = bfs(y1, x1);
            System.out.println(result);

        }
    }

    static public int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x, count});

        while(q.size() != 0){
            int[] poll = q.poll();
            int ny = poll[0];
            int nx = poll[1];
            int ncount = poll[2];
            if(nx == x2 && ny == y2){
                return ncount;
            }
            for(int i=0; i<8; i++){
                int ndy = ny + dy[i];
                int ndx = nx + dx[i];
                if(ndy >= 0 && ndx >= 0 && ndy < size && ndx < size){
                    if(graph[ndy][ndx] != 1){
                        q.add(new int[] {ndy, ndx, ncount + 1});
                        graph[ndy][ndx] = 1;
                    }
                }
            }
        }
        return 0;
    }
}
