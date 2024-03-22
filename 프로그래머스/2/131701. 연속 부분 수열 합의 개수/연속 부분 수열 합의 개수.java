import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
                
        int length = elements.length;
        
        for(int i=1; i<length; i++){
            int count = 0;
            for(int j=0; j < length; j++){
                int sum = 0;
                for(int k=j; k<j+i; k++){
                    int temp = k;
                    if(temp / length > 0){
                        temp %= length;
                    }
                    sum += elements[temp];
                }
                set.add(sum);
            }
        }
        int sum = 0;
        for(int i=0; i<length; i++){
            sum += elements[i];
        }
        set.add(sum);
        
        
        return set.size();
    }
}