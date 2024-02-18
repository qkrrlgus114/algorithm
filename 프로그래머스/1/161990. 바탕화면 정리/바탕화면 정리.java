import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int s_y = Integer.MAX_VALUE;
        int s_x = Integer.MAX_VALUE;
        int b_y = Integer.MIN_VALUE;
        int b_x = Integer.MIN_VALUE;
        
        // . = 0, # = 1
        int[][] graph = new int[wallpaper.length][wallpaper[0].length()];
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[0].length; j++){
                if(wallpaper[i].charAt(j) == '.') graph[i][j] = 0;
                else{
                    graph[i][j] = 1;
                    if(s_y > i) s_y = i;
                    if(s_x > j) s_x = j;
                    if(b_y < i) b_y = i;
                    if(b_x < j) b_x = j;
                } 
            }    
        }
        
        
        
        // System.out.println(Arrays.deepToString(graph));
        return new int[]{s_y, s_x, b_y + 1, b_x + 1};
    }
}