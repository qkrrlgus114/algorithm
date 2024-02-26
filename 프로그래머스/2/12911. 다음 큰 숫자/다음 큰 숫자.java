class Solution {
    public int solution(int n) {
        // n의 1의 개수 구함
        int n_one_count = binaryChange(n);
        
        for(int i=n+1; i<=1000000; i++){
            if(binaryChange(i) == n_one_count){
                return i;
            }
        }
        return 1;
    }
    
    public static int binaryChange(int num){
        int count = 0;
        while(num >= 1){
            if(num % 2 == 1){
                count++;
            } 
            num /= 2;
        }
        return count + 1;
    }
}