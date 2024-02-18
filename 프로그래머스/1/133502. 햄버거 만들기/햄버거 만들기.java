import java.util.*;

class Solution {
    // 1 - 빵, 2 - 야채, 3 - 고기
    public int solution(int[] ingredient) {
        int result = 0;
        
        Stack<Integer> s = new Stack<>();
        
        for(int temp : ingredient){
            s.push(temp);
            
            if(s.size() >= 4){
                if(s.get(s.size() - 4) == 1
                  && s.get(s.size() - 3) == 2
                  && s.get(s.size() - 2) == 3
                  && s.get(s.size() - 1) == 1){
                    for(int i=0; i<4; i++){
                        s.pop();
                    }
                    result++;
                }
            }
        }
        return result;
    }
}