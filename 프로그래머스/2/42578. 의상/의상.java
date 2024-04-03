import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int count = 1;
        
        for(Integer i : map.values()){
            count *= i + 1;
        }
        
        return count - 1;
    }
}