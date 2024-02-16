import java.util.*;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        int[] result = new int[targets.length];
        
        for(int i=0; i<keymap.length; i++){
            char[] temp_char = keymap[i].toCharArray();
            for(int j=0; j<temp_char.length; j++){
                if(alpha[temp_char[j] - 65] == -1 || alpha[temp_char[j] - 65] > j){
                    alpha[temp_char[j] - 65] = j+1;
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            char[] temp_char = targets[i].toCharArray();
            int sum = 0;
            for(int j=0; j<temp_char.length; j++){
                if(alpha[temp_char[j] - 65] != -1) sum += alpha[temp_char[j] - 65];
                else if(alpha[temp_char[j] - 65] == -1){
                    sum = -1;
                    break;
                }
            }
            result[i] = sum;
        
        }
        
        return result;
    }
}