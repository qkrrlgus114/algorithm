class Solution {
    static int[] memo;
    public int solution(int n) {
        memo = new int[n + 1];
        memo[1] = 1;
        
        return dp(n);
    }
    
    public static int dp(int num){
        if(num <= 1){
            return num;
        }
        if(memo[num] != 0){
            return memo[num];
        }
        
        return memo[num] = (dp(num - 1) + dp(num - 2)) % 1234567;
    }
}