import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int h = (n / w) + 1;
        
        int[][] spaces = new int[h][w];
        int value = 1;
        int colIdx = 0;
        boolean dir = true; // true 오른쪽, false 왼쪽
        
        for(int i=h-1; i>=0; i--){
            while(true){
                if(!dir){
                    if(value > n) break;
                    if(colIdx < 0){
                        colIdx++;
                        dir = true;
                        break;
                    }
                    spaces[i][colIdx--] = value++;
                }else{
                    if(value > n) break;
                    if(colIdx == w) {
                        colIdx--;
                        dir = false;
                        break;
                    }
                    spaces[i][colIdx++] = value++;
                }
            }
        }
        
        int answer = 0;
        
        outer: for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(spaces[i][j] == num){
                    System.out.println(i + " " + j);
                    while(true){
                        if(i - 1 >= 0 && spaces[i-1][j] != 0){
                            answer++;
                            i--;
                        }else{
                            break outer;
                        }
                    }

                }
            }
        }
        
        
        return answer + 1;
    }
}