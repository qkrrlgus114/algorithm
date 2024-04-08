import java.util.*;

class Solution {
    static int result = 0;
    static StringBuilder sb = new StringBuilder();
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        dfs(0, word);

        return result;
    }
    
    public static boolean dfs(int depth, String word){
        if(word.equals(sb.toString())){
            return true;
        }
        if(depth == 5) return false;
        
        for(int i=0; i<5; i++){
            sb.append(arr[i]);
            result++;
            if(dfs(depth + 1, word)) return true;
            sb.setLength(sb.length() - 1);
        }
        
        return false;
    }
}