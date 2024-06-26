import java.util.*;

class Solution{

    static int N, M;
    // 변의 최대 길이
    static int result = 0;
    
    public int solution(int [][]board){
        N = board.length;
        M = board[0].length;
        
        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                if(board[i][j] == 0) continue;
                if(result == 0) result = 1;
                int min = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1]));
                board[i][j] = min + 1;
                result = Math.max(result, board[i][j]);
            }
        }
        
        if(board.length == 1){
            if(board[0][0] == 1) result = 1;
            else result = 0;
        }

        return result * result;
    }
}