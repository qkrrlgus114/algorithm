import java.util.*;

class Solution {
    
    static int[] memo = new int[1000001];
    
    public int solution(int x, int y, int n) {
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[x] = 0;
        
        for(int i=x; i<=y; i++){
            if(memo[i] == Integer.MAX_VALUE) continue;
            
            if(i + n <= y){
                memo[i + n] = Math.min(memo[i + n], memo[i] + 1);
            }
            if(i * 2 <= y){
                memo[i * 2] = Math.min(memo[i * 2], memo[i] + 1);
            }
            if(i * 3 <= y){
                memo[i * 3] = Math.min(memo[i * 3], memo[i] + 1);
            }
        }
        
        return memo[y] == Integer.MAX_VALUE ? -1 : memo[y];
        
    }
}