

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long result = 0;
        Arrays.sort(weights);
        
        Map<Integer, Long> map = new HashMap<>();
        for(int weight : weights){
            map.put(weight, map.getOrDefault(weight, 0L) + 1L);
        }
        
        for(Integer num : map.keySet()){
            Long temp = map.getOrDefault(num, 0L);
            
            if(temp > 1){
                result += (temp - 1) * temp / 2;
            }
            
            if(num % 2 == 0){
                result += temp * map.getOrDefault(num*3/2, 0L);
            }
            if(num % 3 == 0){
                result += temp * map.getOrDefault(num*4/3, 0L);
            }
            result += temp * map.getOrDefault(num*2, 0L);
        }

        return result;
    }
}