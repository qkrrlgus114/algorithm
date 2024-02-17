import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        int[] alpha_check = new int[26];
        char[] temp = skip.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        // skip에 있는 문자 체크 배열
        for(int i=0; i<temp.length; i++){
            alpha_check[temp[i] - 97] = 1;
        }
        
        for(int i=0; i<s.length(); i++){
            int temp_index = index;
            char[] temp_s = s.toCharArray();
            int s_index = temp_s[i] - 97;
            while(temp_index != 0){
                // 만약에 다음 인덱스가 z를 넘으면
                if(s_index + 1 >= 26){
                    s_index = 0;
                }else{
                    s_index++;
                }
                if(alpha_check[s_index] == 1) continue;
                else{
                    temp_index--;
                }
            }
        
            sb.append((char) (s_index + 97));
        }
        
        
        return sb.toString();
    }
}