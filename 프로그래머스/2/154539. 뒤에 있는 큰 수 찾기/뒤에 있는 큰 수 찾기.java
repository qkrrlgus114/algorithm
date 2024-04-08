import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[numbers.length];
        
        s.push(0);
        for(int i=1; i<numbers.length; i++){
            while(!s.isEmpty() && numbers[s.peek()] < numbers[i]){
                result[s.peek()] = numbers[i];
                s.pop();
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            result[s.pop()] = -1;
        }
        return result;
    }
}