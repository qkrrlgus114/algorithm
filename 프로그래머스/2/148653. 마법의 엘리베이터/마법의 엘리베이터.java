import java.util.*;

class Solution {
    public int solution(int storey) {
        int totalCount = 0;
        
        while(storey != 0){
            int num = storey % 10;
            storey /= 10;
            
            if(num > 5){
                totalCount += 10 - num;
                storey++;
            } else if(num < 5){
                totalCount += num;
            } else{
                if(storey % 10 >= 5){
                    totalCount += num;
                    storey++;
                }else{
                    totalCount += num;
                }
            }
        }
        return totalCount;
    }

}