class Solution {
    // L R U D
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 방문체크 (출발y, 출발x, 도착y, 도착x)
    static boolean[][][][] visited;
    // 0, 0, 10, 10 (10까지 가능)
    
    public int solution(String dirs) {
        visited = new boolean[11][11][11][11];
        int step_count = 0;
        int cur_y = 5;
        int cur_x = 5;
        
        for(int i=0; i<dirs.length(); i++){
            char command = dirs.charAt(i);
            if(command == 'L'){
                if(cur_x + dx[0] < 0) continue;
                int cur_nx = cur_x + dx[0];
                if(!visited[cur_y][cur_x][cur_y][cur_nx] && !visited[cur_y][cur_nx][cur_y][cur_x]){
                    step_count++;
                    visited[cur_y][cur_x][cur_y][cur_nx] = true;
                    visited[cur_y][cur_nx][cur_y][cur_x] = true;
                }
                cur_x = cur_nx;
            }else if(command == 'R'){
                if(cur_x + dx[1] > 10) continue;
                int cur_nx = cur_x + dx[1];
                if(!visited[cur_y][cur_x][cur_y][cur_nx] && !visited[cur_y][cur_nx][cur_y][cur_x]){
                    step_count++;
                    visited[cur_y][cur_x][cur_y][cur_nx] = true;
                    visited[cur_y][cur_nx][cur_y][cur_x] = true;
                }
                cur_x = cur_nx;
            }else if(command == 'U'){
                if(cur_y + dy[2] < 0) continue;
                int cur_ny = cur_y + dy[2];
                if(!visited[cur_y][cur_x][cur_ny][cur_x] && !visited[cur_ny][cur_x][cur_y][cur_x]){
                    step_count++;
                    visited[cur_y][cur_x][cur_ny][cur_x] = true;
                    visited[cur_ny][cur_x][cur_y][cur_x] = true;
                }
                cur_y = cur_ny;
            }else if(command == 'D'){
                if(cur_y + dy[3] > 10) continue;
                int cur_ny = cur_y + dy[3];
                if(!visited[cur_y][cur_x][cur_ny][cur_x] && !visited[cur_ny][cur_x][cur_y][cur_x]){
                    step_count++;
                    visited[cur_y][cur_x][cur_ny][cur_x] = true;
                    visited[cur_ny][cur_x][cur_y][cur_x] = true;
                }
                cur_y = cur_ny;
            }
        }
        
        return step_count;
    }
}