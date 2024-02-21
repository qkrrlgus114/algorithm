import java.util.*;

class Solution {
    
    // 동 서 남 북
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    // 초기 위치
    static int init_y;
    static int init_x;
    static char[][] graph;

    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        graph = new char[N][M];
        
        
        for(int i=0; i<N; i++){
            graph[i] = park[i].toCharArray();
            for(int j=0; j<M; j++){
                if(graph[i][j] == 'S'){
                    init_x = j;
                    init_y = i;
                }
            }
        }
        
        // 명령 수행
        for(int i=0; i<routes.length; i++){
            char dir = routes[i].charAt(0);
            int count = routes[i].charAt(2) - 48;
            // 이동
            move(dir, count);
        }
        
        int[] result = new int[2];
        result[0] = init_y;
        result[1] = init_x;
        
        return result;
    }
    
    public static void move(char dir, int count){
        int dir_num = 0;
        int temp_y = init_y;
        int temp_x = init_x;
        
        if(dir == 'E') dir_num = 0;
        else if(dir == 'W') dir_num = 1;
        else if(dir == 'S') dir_num = 2;
        else if(dir == 'N') dir_num = 3;
        
        while(count > 0){
            int ndy = temp_y + dy[dir_num];
            int ndx = temp_x + dx[dir_num];
            if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) return;
            if(graph[ndy][ndx] == 'X') return;
            
            temp_y = ndy;
            temp_x = ndx;
            
            count--;
        }
        
        init_y = temp_y;
        init_x = temp_x;
    }
}