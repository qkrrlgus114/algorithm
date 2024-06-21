import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int result = enemy.length;
        
        for(int i=0; i<enemy.length; i++){
            q.add(enemy[i]);
            n -= enemy[i];
            
            if(n < 0){
                if(k > 0 && !q.isEmpty()){
                    int temp = q.poll();
                    n += temp;
                    k--;
                }else{
                    result = i;
                    break;
                }
            }
        }
        
        return result;
    }
}