import java.util.*;

class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%3);
            n/=3;
        }
        int result = Integer.parseInt(sb.toString(), 3);
        return result;
    }
}