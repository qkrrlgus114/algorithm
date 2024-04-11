import java.util.*;

class Solution {
    static char[][] kakaoBoard;
    static boolean[][] canBlockBoard;
    static int crushedBlock = 0;
    
    public int solution(int m, int n, String[] board) {
        kakaoBoard = new char[m][n];
        canBlockBoard = new boolean[m][n];
        
        for(int i=0; i<kakaoBoard.length; i++){
            kakaoBoard[i] = board[i].toCharArray();
        }
        
        while(true){
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(kakaoBoard[i][j] == '#') continue;
                    // 부술 수 있으면 true로 변경
                    isCrushBlock(i, j, m, n);
                }
            }
            // true인 블럭 전부 부숨
            if(crushBlock(m, n)){
                // 블럭 아래로 내림
                downBlock(m, n);
            }else{
                break;
            }
        }
        return crushedBlock;
    }
    
    // 부술 수 있는지 확인
    public static void isCrushBlock(int y, int x, int m, int n){
        // 현재 위치
        char block = kakaoBoard[y][x];
        // 오른쪽 확인
        if(kakaoBoard[y][x+1] != block) return;
        
        // 아래 확인
        if(kakaoBoard[y+1][x] != block) return;
        
        // 오른쪽 아래 대각선 확인
        if(kakaoBoard[y+1][x+1] != block) return;
        
        canBlockBoard[y][x] = true;
        canBlockBoard[y+1][x] = true;
        canBlockBoard[y][x+1] = true;
        canBlockBoard[y+1][x+1] = true;
    }
    
    // 블럭 부수기
    public static boolean crushBlock(int m, int n){
        boolean check = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(canBlockBoard[i][j]){
                    check = true;
                    kakaoBoard[i][j] = '#';
                    canBlockBoard[i][j] = false;
                    crushedBlock++;
                } 
            }
        }
        return check;
    }
    
    // 블럭 내림
    public static void downBlock(int m, int n){
        for(int j=0; j<n; j++){
            for(int i=m-1; i>=0; i--){
                if(kakaoBoard[i][j] == '#'){
                    for(int k=i-1; k>=0; k--){
                        if(kakaoBoard[k][j] != '#'){
                            kakaoBoard[i][j] = kakaoBoard[k][j];
                            kakaoBoard[k][j] = '#';
                            break;
                        }
                    }
                }
            }
        }
        
    }
}