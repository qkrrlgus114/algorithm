import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1Value = 0;
        long q2Value = 0;
        int limit = queue1.length * 3 - 3;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int num : queue1){
            q1Value += (long) num;
            q1.add(num);
        } 
        for(int num : queue2){
            q2Value += (long) num;
            q2.add(num);
        } 
        long target = (q1Value + q2Value) / 2;
        
        int count = 0;
        boolean check = true;
        while(count <= limit){
            if(q1Value == target) break;
            else if(q1.isEmpty() || q2.isEmpty()){
                check = false;
                break;
            } 
            else if(q1Value < target){
                int temp = q2.poll();
                q1Value += temp;
                q1.add(temp);
            }else if(q1Value > target){
                int temp = q1.poll();
                q1Value -= temp;
                q2.add(temp);
            }
            
            count++;
        }
        
        if(!check) return -1;
        
        return count > limit ? -1 : count;
    }
}
