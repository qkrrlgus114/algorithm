class Solution {
    
    static int result = 0;
    static int N;
    static boolean[] visited;
    static int[][] static_deungeons;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        static_deungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(0, 0, k);
        
        
        return result;
    }
    
    public static void dfs(int depth, int count, int cur_health){
        // 종료 조건
        if(depth == N){
            result = Math.max(result, count);
            return;
        }
        
        for(int i=0; i < N; i++){
            if(visited[i]) continue;
            if(cur_health - static_deungeons[i][0] < 0) continue;
            visited[i] = true;
            dfs(depth + 1, count+1, cur_health - static_deungeons[i][1]);
            visited[i] = false;
        }
        dfs(N, count, cur_health);
    }
}