import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[25];
        int answer = 0;
        
        for(int i=0; i<players.length; i++){
            int player = players[i];
            
            if(player / m <= servers[i]){
                continue;
            }
            answer += (player/m) - servers[i];
            
            // 증설해야하는 서버 개수
            int plus = (player/m) - servers[i];
            
            for(int j=i; j<i + k; j++){
                if(j == 24) break;
                servers[j] += plus;
            }
        }
        
        return answer;
    }
}