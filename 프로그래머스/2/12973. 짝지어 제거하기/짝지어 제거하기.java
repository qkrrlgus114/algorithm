import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(stack.size() == 0){
                stack.push(c);
            }else{
                if(c == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        if(!stack.isEmpty()) return 0;
        return 1;
    }
}