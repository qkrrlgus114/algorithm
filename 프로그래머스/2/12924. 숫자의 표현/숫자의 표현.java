class Solution {
    public int solution(int n) {
        int result = 0;
        
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=i; j<=n; j++){
                sum += j;
                
                if(sum == n){
                    result++;
                    sum -= j;
                    break;
                }
                if(sum > n){
                    sum -= j;
                    break;
                }
            }
        }
        
        return result;
    }
}