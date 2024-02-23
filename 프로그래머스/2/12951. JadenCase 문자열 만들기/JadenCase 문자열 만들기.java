import java.util.*;

class Solution {
    
    // a = 97, z = 122, A = 65, Z = 90
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(word.length() == 0) sb.append(" ");
            else{
                // 첫 글자는 대문자로
                sb.append(word.substring(0, 1).toUpperCase());
                // 나머지느 소문자로
                sb.append(word.substring(1, word.length()).toLowerCase());
                sb.append(" ");
            }

        }

        return sb.substring(0, sb.length() - 1).toString();
    }
    
}