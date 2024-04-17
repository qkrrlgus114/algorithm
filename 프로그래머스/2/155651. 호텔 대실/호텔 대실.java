import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int result = 0;
        
        int[] rooms = new int[1880];
        for(int i=0; i<book_time.length; i++){
            String inTime = book_time[i][0];
            String outTime = book_time[i][1];
            
            rooms[cal(inTime)]++;
            rooms[cal(outTime) + 10]--;
        }
        
        for(int i=1; i<rooms.length; i++){
            rooms[i] += rooms[i-1];
            result = Math.max(result, rooms[i]);
        }

        
        return result;
    }
    
    public static int cal(String time){
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));
        
        return (h * 60) + m;
    }
}