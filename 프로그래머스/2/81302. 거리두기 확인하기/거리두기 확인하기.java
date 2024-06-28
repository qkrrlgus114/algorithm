import java.util.*;

class Solution {
    
    static char[][] arr;
    
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        int index = 0;
        
        for(int t=0; t<5; t++){
            arr = new char[5][5];
            for(int i=0; i<5; i++){
                arr[i] = places[t][i].toCharArray();
            }
            
            boolean check = true;
            outer: for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(arr[i][j] != 'P') continue;
                    if(!checkDistance(i, j)){
                        check = false;
                        break outer;
                    }
                }
            }
            if(check) result[index++] = 1;
            else result[index++] = 0;
            
        }

        return result;
    }
    
    private static boolean checkDistance(int y, int x){
        // 상
        int oriY = y;
        int oriX = x;
        for(int i=y-1; i >= y-2; i--){
            if(i < 0) break;
            if(arr[i][x] == 'P' && arr[i+1][x] != 'X') return false;
        }
        // 하
        y = oriY;
        x = oriX;
        for(int i=y+1; i <= y+2; i++){
            if(i >= 5) break;
            if(arr[i][x] == 'P' && arr[i-1][x] != 'X') return false;
        }
        // 좌
        y = oriY;
        x = oriX;
        for(int j=x-1; j >= x-2; j--){
            if(j < 0) break;
            if(arr[y][j] == 'P' && arr[y][j+1] != 'X') return false;
        }
        // 우
        y = oriY;
        x = oriX;
        for(int j=x+1; j <= x+2; j++){
            if(j >= 5) break;
            if(arr[y][j] == 'P' && arr[y][j-1] != 'X') return false;
        }
        // 우상
        y = oriY;
        x = oriX;
        if(y-1 >= 0 && x+1 < 5 && arr[y-1][x+1] == 'P' && (arr[y-1][x] != 'X' || arr[y][x+1] != 'X')){
            return false;
        }
        // 우하
        if(y+1 < 5 && x+1 < 5 && arr[y+1][x+1] == 'P' && (arr[y+1][x] != 'X' || arr[y][x+1] != 'X')){
            return false;
        }
        // 좌하
        if(y+1 < 5 && x-1 >= 0 && arr[y+1][x-1] == 'P' && (arr[y+1][x] != 'X' || arr[y][x-1] != 'X')){
            return false;
        }
        // 좌상
        if(y-1 >= 0 && x-1 >= 0 && arr[y-1][x-1] == 'P' && (arr[y-1][x] != 'X' || arr[y][x-1] != 'X')){
            return false;
        }
        
        return true;
    }
}