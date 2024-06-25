import java.util.*;

// 끝에 도달하면 멈춘다.
// D에 부딪히면 멈춘다.
// 멈춘 지점이 G면 최소 이동 거리

class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};
    static int result = -1;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            map[i] = board[i].toCharArray();
        }
        
        int startY = 0;
        int startX = 0;
        
        outer: for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
               if(map[i][j] == 'R'){
                   startY = i;
                   startX = j;
                   break outer;
               } 
            }
        }
        bfs(startY, startX);
        

        return result;
    }
    
    private static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y, x, 0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int step = temp[2];
            for(int i=0; i<4; i++){
                temp = moveRobot(y, x, i);
                if(visited[temp[0]][temp[1]]) continue;
                if(map[temp[0]][temp[1]] == 'G'){
                    result = step + 1;
                    return;
                }
                visited[temp[0]][temp[1]] = true;
                q.add(new int[]{temp[0], temp[1], step + 1});
            }
        }
    }
    
    private static int[] moveRobot(int y, int x, int dir){
        // 상 하 좌 우
        if(dir == 0){
            while(true){
                y--;
                if(y < 0 || map[y][x] == 'D'){
                    return new int[]{y+1, x};
                }
            }
        }else if(dir == 1){
            while(true){
                y++;
                if(y >= N || map[y][x] == 'D'){
                    return new int[]{y-1, x};
                }
            }
        }else if(dir == 2){
            while(true){
                x--;
                if(x < 0 || map[y][x] == 'D'){
                    return new int[]{y, x+1};
                }
            }
        }else{
            while(true){
                x++;
                if(x >= M || map[y][x] == 'D'){
                    return new int[]{y, x-1};
                }
            }
        }
    }
    
}