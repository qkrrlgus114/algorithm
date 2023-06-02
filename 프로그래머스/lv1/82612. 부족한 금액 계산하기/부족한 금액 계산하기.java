class Solution {
    public long solution(long price, long money, long count) {
        long temp = price;
        long sum = price;
        for(int i=1; i<count; i++){
            temp +=price;
            sum += temp;
        }
        if(sum-money>0){
            return sum-money;
        }else{
            return 0;
        }
        
    }
}