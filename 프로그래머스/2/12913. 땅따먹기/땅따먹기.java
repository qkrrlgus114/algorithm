class Solution {
    int solution(int[][] land) {
        
        int[][] dp = new int[land.length][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                if(j == 0){
                    dp[i][0] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3]) + land[i][0];
                }else if(j == 1){
                    dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3]) + land[i][1];
                }else if(j == 2){
                    dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3]) + land[i][2];
                }else if(j == 3){
                    dp[i][3] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + land[i][3];
                }
            }
        }
        int N = land.length - 1;
        int answer = Math.max(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]), dp[N][3]);

        return answer;
    }
}