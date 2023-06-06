import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                hashSet.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        return list;
    }
}