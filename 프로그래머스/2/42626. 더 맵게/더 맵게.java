import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i : scoville){
            q.add((long) i);
        }
        int count = 0;
        boolean check = false;
        
        while(true){
            if(q.peek() >= K){
                check = true;
                break;
            }
            if(q.size() == 1) break;
            
            long temp1 = q.poll();
            long temp2 = q.poll();
            long temp3 = temp1 + (temp2 * 2);
            count++;
            
            q.add(temp3);
        }
        
        if(check) return count;
        return -1;
    }
}