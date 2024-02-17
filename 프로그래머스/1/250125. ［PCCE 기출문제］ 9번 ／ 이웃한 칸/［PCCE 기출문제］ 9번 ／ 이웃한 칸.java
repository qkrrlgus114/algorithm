import java.util.*;

class Solution {
    
    public int solution(String[][] board, int h, int w) {
        int N = board.length;
        int M = board[0].length;
        int[][] graph = new int[N][M];
        int result = 0;
        // 상 우 하 좌
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1 ,0};
        
        String cur_color = board[h][w];
        for(int t=0; t<4; t++){
            int ndx = dx[t] + w;
            int ndy = dy[t] + h;
            if(ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
            if(board[ndy][ndx].equals(cur_color)) result++;
        }
        
        return result;
    }
}