import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        char first = ' ';
        int same = 0;
        int different = 0;
        int result = 0;
        
        for(char c : s.toCharArray()){
            if(first == ' '){
                first = c;
                result++;
                same++;
            }else if(first == c){
                same++;
            }else{
                different++;
            }
            
            if(same == different){
                first = ' ';
            }
        }
        
        return result;
        
    }
}