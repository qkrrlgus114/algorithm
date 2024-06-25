import java.util.*;

class Solution {
    
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    // 상 하 좌 우
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int switchY = 0;
    static int switchX = 0;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            map[i] = maps[i].toCharArray();
        }
        
        int startY = 0;
        int startX = 0;
        outer: for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 'S'){
                    startY = i;
                    startX = j;
                    break outer;    
                }
            }
        }
        
        int shortSwitch = bfsSwitch(startY, startX);
        if(shortSwitch == -1) return -1;
        visited = new boolean[N][M];
        int shortEnd = bfsEnd(switchY, switchX);
        if(shortEnd == -1) return -1;

        return shortSwitch + shortEnd;
    }
    
    // 레버까지 최단 거리
    private static int bfsSwitch(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int step = temp[2];
            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(visited[ndy][ndx] || map[ndy][ndx] == 'X') continue;
                if(map[ndy][ndx] == 'L'){
                    switchY = ndy;
                    switchX = ndx;
                    return step + 1;
                }
                visited[ndy][ndx] = true;
                q.add(new int[]{ndy, ndx, step + 1});
                
            }
        }
        
        return -1;
    }
    
    // 레버부터 탈출구까지 최단거리
    private static int bfsEnd(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int step = temp[2];
            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(visited[ndy][ndx] || map[ndy][ndx] == 'X') continue;
                if(map[ndy][ndx] == 'E'){
                    return step + 1;
                }
                visited[ndy][ndx] = true;
                q.add(new int[]{ndy, ndx, step + 1});
                
            }
        }
        
        return -1;
    }
}