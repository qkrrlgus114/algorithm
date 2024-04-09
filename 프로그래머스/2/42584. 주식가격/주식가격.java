class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                result[i]++;
                // 가격이 떨어졌다면
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
        
        return result;
    }
}