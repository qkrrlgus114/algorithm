import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static Set<String> duplicate = new HashSet<>();
    
    public int solution(int[][] info, int n, int m) {
        dfs(0, 0, 0, n, m, info);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public static void dfs(int a, int b, int cnt, int n, int m, int[][] info){
        if(a > answer) return;
        String key = a + ":" + b + ":" + cnt;
        if(duplicate.contains(key)) return;
        // 종료
        if(cnt == info.length){
            answer = Math.min(answer, a);
            return;
        }
        
        duplicate.add(key);
        if(b + info[cnt][1] < m){
            dfs(a, b + info[cnt][1], cnt + 1, n, m, info);
        }
        if(a + info[cnt][0] < n){
            dfs(a + info[cnt][0], b, cnt + 1, n, m, info);
        }
    }
}