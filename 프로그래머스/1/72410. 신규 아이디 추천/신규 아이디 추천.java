import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        char[] name = new_id.toCharArray();
        // 1단계
        for(int i=0; i<name.length; i++){
            if(name[i] >= 65 && name[i] <= 90){
                name[i] = (char) (name[i] + 32);
            }
        }
        
        // 2단계
        for(int i=0; i<name.length; i++){
            if((name[i] < 97 || name[i] > 122) && (name[i] < 48 || name[i] > 57) && name[i] != 45 && name[i] != 46 && name[i] != 95){
                name[i] = ' ';
            }
        }
        
        // 3단계
        int start = -1;
        int end = -1;
        for(int i=0; i<name.length; i++){
            if(start != -1 && name[i] == 46) end = i;
            else if(name[i] == 46) start = i;
            else if(name[i] == 32) continue;
            else if(name[i] != 46){
                if(end != -1){
                    for(int j=start; j<=end; j++){
                        if(j == start) continue;
                        else name[j] = ' ';
                    }
                }
                start = -1;
                end = -1;
            }
        }
        if(end != -1){
            for(int j=start; j<=end; j++){
                if(j == start) continue;
                else name[j] = ' ';
            }
        }
        // 4단계
        for(int i=0; i<name.length; i++){
            if(name[i] != ' ' && name[i] != '.') break;
            else if(name[i] == '.'){
                name[i] = ' ';
                break;
            }
        }
        for(int i=name.length - 1; i >= 0; i--){
            if(name[i] != ' ' && name[i] != '.') break;
            else if(name[i] == '.'){
                name[i] = ' ';
                break;
            }
        }
        
        // 5단계
        boolean check = false;
        for(int i=0; i<name.length; i++){
            if(name[i] != ' '){
                check = true;
                break;
            }
        }
        
        // 6단계
        int len = 0;
        for(int i=0; i<name.length; i++){
            if(len == 15) break;
            if(name[i] != ' '){
                sb.append(name[i]);
                len++;
            }
        }
        if(!check) sb.append("a");
        if(sb.charAt(0) == '.') sb.delete(0, 1);
        if(sb.charAt(sb.length() - 1) == '.') sb.delete(sb.length() - 1, sb.length());
        
        // 7단계
        while(sb.length() <= 2){
            char temp = sb.charAt(sb.length() - 1);
            sb.append(temp);
        }
        
        return sb.toString();
    }
}