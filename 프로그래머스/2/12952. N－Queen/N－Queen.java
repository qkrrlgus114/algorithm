class Solution {
    
    static boolean[][] board;
    static int result = 0;
    
    public int solution(int n) {
        board = new boolean[n][n];
        
        dfs(0, n);
        
        return result;
    }
    
    private static void dfs(int row, int n){
        if(row == n){
            result++;
            return;
        }
        

        for(int col = 0; col < n; col++){
            if(check(row, col, n)){
                board[row][col] = true;
                dfs(row + 1, n);
                board[row][col] = false;
            }
        }
        
        
    }
    
    private static boolean check(int row, int col, int n){
        int oriRow = row;
        int oriCol = col;
        
        // 위 확인
        for(int i=row; i>=0; i--){
            if(board[i][col]) return false;
        }
        
        // 왼쪽 위 확인
        while(row - 1 >= 0 && col - 1 >= 0){
            row--;
            col--;
            if(board[row][col]) return false;
        }
        
        row = oriRow;
        col = oriCol;
        
        // 오른쪽 위 확인
        while(row - 1 >= 0 && col + 1 < n){
            row--;
            col++;
            if(board[row][col]) return false;
        }
        
        return true;
    }
}