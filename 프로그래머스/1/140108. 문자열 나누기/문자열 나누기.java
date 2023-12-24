import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int result = 0;
        int equalsCount = 0;
        int notEqualsCount = 0;
        char first = ' ';
        // 현재 잘랐는지 안 잘랐는지 판단
        boolean check = false;
        
        while(true){
            for(int i=0; i<s.length(); i++){
                if(i == 0){
                    first = s.charAt(i);
                    equalsCount++;
                    continue;
                }
                
                if(first == s.charAt(i)){
                    equalsCount++;
                }else{
                    notEqualsCount++;
                }
                
                if(equalsCount == notEqualsCount){
                    s = s.substring(i+1, s.length());
                    result++;
                    check = true;
                    equalsCount = 0;
                    notEqualsCount = 0;
                    first = ' ';
                    break;
                }
            }
            
            if(!check){
                if(s.length() == 0){
                    break;
                }
                result++;
                break;
            }else{
                check = false;
            }
        }
        return result;
        
    }
}