// 1. k > 0
// 2. 스택 있음
// 3. num > 스택.peek() 
// 위 3가지 만족하면 k--


import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<number.length(); i++){
            int num = number.charAt(i) - '0';
            while(true){
                if(k > 0 && !s.isEmpty() && s.peek() < num){
                    s.pop();
                    k--;
                }else break;
            }
            s.push(num);
        }

        while(k > 0){
            s.pop();
            k--;
        }
        
        int[] arr = new int[s.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = s.pop();
        }
        
        for(int i=arr.length - 1; i >= 0; i--){
            sb.append(arr[i]);
        } 
        
        return sb.toString();
    }
}