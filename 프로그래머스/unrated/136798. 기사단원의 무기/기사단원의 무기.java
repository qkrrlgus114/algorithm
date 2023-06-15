import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=number; i++){
            list.add(get(i, limit, power));    
        }
        int result = 0;
        for(int i=0; i<list.size(); i++){
            result += list.get(i);
        }
        return result;
    }
    
    public int get(int n, int limit, int power){
        int count = 0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                count++;
                if(i*i < n){
                    count++;
                }
            }
        }
        if(count > limit) return power;
        return count;
    }
}