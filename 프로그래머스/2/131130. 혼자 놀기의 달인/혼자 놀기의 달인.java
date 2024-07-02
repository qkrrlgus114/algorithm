import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<cards.length; i++){
            if(!visited[i]){
                int count = 0;
                int index = i;
                while(true){
                    if(visited[index]) break;
                    count++;
                    visited[index] = true;
                    index = cards[index] - 1;
                }
                answer.add(count);
            }
        }
        Collections.sort(answer, Collections.reverseOrder());
        
        if(answer.size() > 1) return answer.get(0) * answer.get(1);
        return 0;
    }
}