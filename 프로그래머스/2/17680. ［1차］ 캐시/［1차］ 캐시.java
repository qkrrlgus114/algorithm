import java.util.*;

class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new LinkedList<>();
        if(cacheSize == 0) return cities.length * 5;
        

        int count = 0;
        for(String city : cities){
            String lowerCity = city.toLowerCase();
            if(cache.contains(lowerCity)){
                cache.remove(lowerCity);
                count += 1;
                cache.add(lowerCity);
            }else{
                count += 5;
                if(cache.size() == cacheSize){
                    cache.remove(0);
                }
                cache.add(lowerCity);
            }
        }
        return count;
    }
}