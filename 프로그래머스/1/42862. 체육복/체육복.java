import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int result = n - lost.length;
        
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if (lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    result++;
                    break;
                }
            }
        }
                
         for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    result++;
                    break;
                }
            }
        }
        
        return result;
    }
}