import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int[] count = new int[10];
        int max = 0;
        for(int i=0; i<priorities.length; i++){
            count[priorities[i]]++;
            max = Math.max(max, priorities[i]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            if(i == location){
                q.add(new int[]{priorities[i], 1});
            }else{
                q.add(new int[]{priorities[i], 0});
            }
        }
        int answer = 0;
        
        while(true){
            int[] temp = q.poll();
            if(temp[0] != max){
                q.add(temp);
            }else{
                count[temp[0]]--;
                answer++;
                if(temp[1] == 1) break;
                if(count[temp[0]] == 0){
                    // 맥스값 갱신해야함.
                    max = 0;
                    for(int i=0; i<count.length; i++){
                        if(count[i] != 0) max = Math.max(max, i);
                    }
                }
            }
        }
        return answer;
    }
}