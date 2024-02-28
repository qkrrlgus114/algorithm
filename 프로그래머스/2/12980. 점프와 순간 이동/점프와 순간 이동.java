import java.util.*;

public class Solution {
    
    static int[] graph;
    static int min_battery = Integer.MAX_VALUE;
    static int[] visited;
    
    public int solution(int n) {
        int result = 0;
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            }else{
                n--;
                result++;
            }
        }

        return result;
    }
}