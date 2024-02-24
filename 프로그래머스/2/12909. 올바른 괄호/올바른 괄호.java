import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean result = false;
        
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()){
            if(c == '(' || c == '['){
                stack.push(c);
                continue;
            } 
            
            // 스택이 비어있으면 종료
            if(stack.isEmpty()){
                result = true;
                break;
            } 
            // 닫는 거 확인
            if(c == ')' && stack.peek() == '(') stack.pop();
            else if(c == ']' && stack.peek() == '[') stack.pop();
            else{
                result = true;
                break;   
            }
        }
        if(!stack.isEmpty() || result) return false;
        else return true;
    }
}