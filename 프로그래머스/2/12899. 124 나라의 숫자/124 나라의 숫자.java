import java.util.*;

class Solution {
    public String solution(int n) {
        int[] arr = {4, 1, 2};
        Stack<Integer> s = new Stack<>();
        
        while(n != 0){
            int index = n % 3;
            s.push(index);
            if(index == 0) n -= 1;
            n /= 3;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(arr[s.pop()]);
        }
        
        return sb.toString();
    }
}