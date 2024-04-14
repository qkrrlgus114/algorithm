import java.util.*;

class Solution {
    static List<Integer>[] graph;
    
    
    public int solution(int n, int[][] wires) {
        graph = new List[n+1];
        int result = Integer.MAX_VALUE;
        
        for(int i=1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            
            graph[start].add(end);
            graph[end].add(start);
        }
        
        // 하나씩 끊으면서 진행
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];
            boolean[] visited = new boolean[n+1];
            
            // 하나 삭제
            graph[start].remove((Integer) end);
            graph[end].remove((Integer) start);
            
            int one = dfs(1, visited);
            int temp = Math.abs(one - (n - one));
            result = Math.min(result, temp);
            
            
            // 다시 추가
            graph[start].add(end);
            graph[end].add(start);
        }

        return result;
    }
    
    public static int dfs(int depth, boolean[] visited){
        visited[depth] = true;
        int cnt = 1;
        
        for(int next : graph[depth]){
            if(!visited[next]){
                cnt += dfs(next, visited);
            }
        }
        
        return cnt;
    }
}
