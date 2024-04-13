class Solution {
    static int[] memo;
    
    public int solution(int n) {
        memo = new int[n+1];
        memo[1] = 1;
        
        int result = dp(n) % 1000000007;
        
        return result;
    }
    
    public static int dp(int n){
        if(memo[n] != 0) return memo[n];
        if(n == 2) return memo[n] = 2;
        
        return memo[n] = (dp(n-1) % 1000000007) + (dp(n-2) % 1000000007);
    }
}