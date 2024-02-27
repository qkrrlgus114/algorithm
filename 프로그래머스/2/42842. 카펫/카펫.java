class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        int sum = brown + yellow;
        
        // (가로-2) * (세로-2) = yellow 
        // sum의 약수를 구함
        // i 가로, j 세로
        for(int i=1; i<=sum; i++){
            if(sum % i == 0){
                int j = sum / i;
                if(i < 3 || j < 3) continue;
                if(j > i) continue;
                if((i-2) * (j-2) == yellow){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        
        return result;
        
    }
}