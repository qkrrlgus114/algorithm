class Solution {
    static int[] memo;
    public long solution(int n) {
        long answer = 0;
        
        memo = new int[n+1];
        if(n == 1) return 1;
        else if(n == 2) return 2;
        memo[1] = 1;
        memo[2] = 2;
        
        
     
        answer = dp(n);
        return answer;
        
        
        
    }
    
    public static int dp(int num){
        if(memo[num] != 0){
            return memo[num];
        }
        
        return memo[num] = (((dp(num-1) % 1234567) + (dp(num-2) % 1234567)) % 1234567);
    }
}