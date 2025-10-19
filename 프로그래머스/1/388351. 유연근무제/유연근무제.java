import java.util.*;

class Solution {
    
    static int[] check;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        check = new int[timelogs.length];
        // 평일 개수
        int dayCnt = 0;
        
        for(int i=0; i<timelogs[0].length; i++){
            boolean week = false;
            for(int j=0; j<timelogs.length; j++){
                int target = plusMinute10(schedules[j]);
                
                if(startday == 6 || startday == 7) {
                    week = true;
                    break;
                }
                int time = timelogs[j][i];
                
                if(target >= time){
                    check[j]++;
                }
            }
            if(!week){
                dayCnt++;
            }
            startday += 1;
            if(startday > 7) startday = 1;
        }
        
        int answer = 0;
        
        for(int i=0; i<check.length; i++){
            if(check[i] == dayCnt && check[i] != 0){
                answer++;
            }
        }
        
        return answer;
    }
    
    public static int plusMinute10(int target){
        target += 10;
        int time = (target / 100) * 100;
        target %= 100;
        if(target / 60 > 0){
            time += 100;
            target -= 60;
        }
        
        return time + target;
        
    }
}