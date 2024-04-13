import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y+1];
        
        if(x == y) return 0;
        else return bfs(x, y, n);
    }
    
    public static int bfs(int x, int y, int n){
        Queue<int[]> q = new LinkedList<>();
        visited[x] = true;
        q.add(new int[]{x, 0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            x = temp[0];
            int count = temp[1];
            
            // x+n 확인
            if(x + n <= y && !visited[x + n]){
                if(x + n == y) return count + 1;
                visited[x + n] = true;
                q.add(new int[]{x + n, count + 1});
            }
            if(x * 2 <= y && !visited[x * 2]){
                if(x * 2 == y) return count + 1;
                visited[x * 2] = true;
                q.add(new int[]{x * 2, count + 1});
            }
            if(x * 3 <= y && !visited[x * 3]){
                if(x * 3 == y) return count + 1;
                visited[x * 3] = true;
                q.add(new int[]{x * 3, count + 1});
            }
        }
        
        return -1;
    }
}