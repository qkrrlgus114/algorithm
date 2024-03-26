// s의 길이만큼 for문으로 회전을 해야함.
// }]()[{

import java.util.*;

class Solution {

    static Stack<Character> stack = new Stack<>();
    
    public int solution(String s) {
        int result = 0;

        for(int i=0; i<s.length(); i++){
            stack.clear();
            if(check(s.substring(i) + s.substring(0, i))) result++;
        }
        
        return result;
    }

    public static boolean check(String s){
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '[' || cur == '{') stack.push(cur);
            else{
                if(cur == ')'){
                    if(stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                } else if(cur == '}'){
                    if(stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                } else if(cur == ']'){
                    if(stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
}