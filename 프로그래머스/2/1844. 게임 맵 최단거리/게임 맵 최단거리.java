import java.util.*;

class Solution {
    static boolean[][] visited;
    static int result = 0;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N, M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        
        
        bfs(0, 0, maps);
 
        
        if(result == 0) return -1;
        return result;
    }
    
    public static void bfs(int y, int x, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 1});
        visited[y][x] = true;
        
        while(!q.isEmpty()){
            boolean check = false;
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int count = temp[2];
            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;
                if(ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
                if(visited[ndy][ndx] || maps[ndy][ndx] == 0) continue;
                if(ndy == N - 1 && ndx == M - 1){
                    result = count + 1;
                    check = true;
                    break;
                }
                q.add(new int[]{ndy, ndx, count + 1});
                visited[ndy][ndx] = true;
            }
            if(check) break;
            
        }
    }
}