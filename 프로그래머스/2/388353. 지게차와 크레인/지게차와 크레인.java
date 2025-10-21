import java.util.*;

class Solution {
    
    static char[][] spaces;
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        spaces = new char[n][m];
        
        for(int i=0; i<n; i++){
            spaces[i] = storage[i].toCharArray();
        }
        
        for(int i=0; i<requests.length; i++){
            String alpha = requests[i].substring(0, 1);
            int len = requests[i].length();
            
            // 꺼낼 좌표
            List<int[]> pos = new ArrayList<>();
            
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(spaces[j][k] == alpha.charAt(0)){
                        if(len == 1){
                            boolean can;
                            if(j == 0 || k == 0 || j == n - 1 || k == m - 1){
                                can = true;
                            }else{
                                can = canFirstDraw(j, k, n, m);
                            }
                            if(can) pos.add(new int[]{j, k});
                        }else{
                            secondCommand(j, k);
                        }
                    }
                }
            }
            
            if(!pos.isEmpty()){
                for(int[] arr : pos){
                    secondCommand(arr[0], arr[1]);
                }
                
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(spaces[i][j] != '.'){
                    answer++;
                }
            }
        }

        return answer;
    }
    
    public boolean canFirstDraw(int y, int x, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;
        q.add(new int[]{y, x});
        boolean answer = false;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;
                if(ndx < 0 || ndy < 0 || ndx == m || ndy == n){
                    return false;
                }
                if(visited[ndy][ndx]){
                    continue;
                }
                if(spaces[ndy][ndx] == '.'){
                    if(ndy == 0 || ndx == 0 || ndy == n - 1 || ndx == m - 1){
                        return true;
                    }
                    visited[ndy][ndx] = true;
                    q.add(new int[]{ndy, ndx});
                }

            }
        }
        
        return answer;
        
    }
    
    // 지게차
    public void firstCommand(int y, int x, int n, int m){
        // y가 0또는 n-1
        if(y == 0 || y == n - 1){
            spaces[y][x] = '.';
            return;
        }
        
        // x가 0 또는 m-1
        if(x == 0 || x == m - 1){
            spaces[y][x] = '.';
            return;
        }
        
        // 상하좌우가 .인 경우 꺼낼 수 있다.
        if(spaces[y-1][x] == '.' || spaces[y][x-1] == '.' ||spaces[y][x+1] == '.' ||spaces[y+1][x] == '.'){
            spaces[y][x] = '.';
        }
    }
    
    // 크레인
    public void secondCommand(int y, int x){
        spaces[y][x] = '.';
    }
}