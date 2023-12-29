import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[][] map;
    static boolean[][] visited;
    // 상우하좌 순서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String temp = bf.readLine();
            for(int j=0; j<temp.length(); j++){
                map[i][j] = temp.charAt(j) - 48;
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,1});
        visited[y][x] = true;

        while(q.size() != 0){
            int[] poll = q.poll();
            y = poll[0];
            x = poll[1];
            int count = poll[2];

            for(int i=0; i<4; i++){
                int ndy = y + dy[i];
                int ndx = x + dx[i];
                // 범위 내에 있는지 체크
                if(ndy >= 0 && ndx >= 0 && ndy < N && ndx < M){
                    if(!visited[ndy][ndx] && map[ndy][ndx] == 1){
                        if(ndy == N-1 && ndx == M-1){
                            return count + 1;
                        }else{
                            q.add(new int[]{ndy, ndx, count + 1});
                            visited[ndy][ndx] = true;
                        }
                    }
                }
            }
        }

        return 0;
    }
}