import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> player = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            player.put(players[i], i+1);
        }
        
        // 선수 호출 
        for(int i=0; i<callings.length; i++){
            String call = callings[i];
            // 등수 찾기
            int temp = player.get(call);
            if(temp == 1) continue;
            // 앞서가는 사
            String front_player = players[temp - 2];
            
            players[temp - 2] = call;
            players[temp - 1] = front_player;
            
            player.put(call, temp - 1);
            player.put(front_player, temp);
        }
        
        return players;
    }
}