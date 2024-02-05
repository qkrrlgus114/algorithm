import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    * 상어 = -2, 먹힌 물고기 = - 1
    * */
    // 위부터 반시계 방향
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    // 위치 저장 배열(y, x, 방향)
    static int[][] position = new int[17][3];
    static int[][] graph = new int[4][4];
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<4; i++){
            String[] sa = bf.readLine().split(" ");
            int index = 0;
            for(int j=0; j<8; j+=2){
                graph[i][index] = Integer.parseInt(sa[j]);
                position[Integer.parseInt(sa[j])][0] = i;
                position[Integer.parseInt(sa[j])][1] = index++;

            }
            for(int j=1; j<8; j+=2){
                position[Integer.parseInt(sa[j-1])][2] = Integer.parseInt(sa[j]) - 1;
            }
        }

        int fish = graph[0][0];
        graph[0][0] = -2;

//        System.out.println(Arrays.deepToString(position));
        dfs(0, 0, position[fish][2], fish);

        System.out.println(max);
    }

    public static void dfs(int y, int x, int dir, int result){
        List<Integer> eat_shark;

        if(result > max){
            max = result;
        }
        // 물고기 이동 전 상태복사
        int[][] temp_graph = new int[4][4];
        int[][] temp_position = new int[17][3];
        for(int i = 0; i < 4; i++){
            for(int j=0; j<4; j++){
                temp_graph[i][j] = graph[i][j];
            }
        }
        for(int i = 0; i < 17; i++){
            for(int j=0; j<3; j++){
                temp_position[i][j] = position[i][j];
            }
        }

        // 물고기 이동
        fishMove();

        // 현재 위치에서 상어가 먹을 수 있는 물고기 리스트 찾음
        eat_shark = shark(y, x, dir);

        // 상어가 먹을 수 있는 물고기의 리스트만큼 돌아야함.
        for(int i=0; i<eat_shark.size(); i++){
            int fish = eat_shark.get(i);
            int fish_y = position[fish][0];
            int fish_x = position[fish][1];
            graph[fish_y][fish_x] = -2;
            graph[y][x] = -1;
            dfs(fish_y, fish_x, position[fish][2], result + fish);
            graph[fish_y][fish_x] = fish;
            graph[y][x] = -2;
        }
        for(int i = 0; i < 4; i++){
            for(int j=0; j<4; j++){
                graph[i][j] = temp_graph[i][j];
            }
        }
        for(int i = 0; i < 17; i++){
            for(int j=0; j<3; j++){
                position[i][j] = temp_position[i][j];
            }
        }

    }

    // 물고기 이동
    public static void fishMove(){
        for(int i=1; i<=16; i++){
            // 먹힌 물고기가 아니면 이동하려고 함.
            int po_y = position[i][0];
            int po_x = position[i][1];
            if(graph[po_y][po_x] == i){
                int dir = position[i][2];
                for(int j=0; j<8; j++){
                    int ndir = (dir + j) % 8;
                    int ndx = dx[ndir] + po_x;
                    int ndy = dy[ndir] + po_y;
                    if(ndy >= 0 && ndx >= 0 && ndy < 4 && ndx < 4){
                        // 상어가 있으면 못감
                        if(graph[ndy][ndx] == -2) continue;
                        int target_fish = graph[ndy][ndx];
                        if(target_fish == -1){
                            // 현재 물고기 위치 빈 칸으로 설정
                            graph[po_y][po_x] = -1;
                            // 이제 이동하는 곳의 위치를 저장해야함.
                            graph[ndy][ndx] = i;
                            position[i][0] = ndy;
                            position[i][1] = ndx;
                            position[i][2] = ndir;
                        }else{
                            graph[po_y][po_x] = target_fish;
                            graph[ndy][ndx] = i;
                            position[i][0] = ndy;
                            position[i][1] = ndx;
                            position[i][2] = ndir;
                            position[target_fish][0] = po_y;
                            position[target_fish][1] = po_x;
                        }
                        break;
                    }
                }
            }
        }
    }

    // 상어가 먹을 수 있는 물고기 확인
    public static List<Integer> shark(int y, int x, int dir){
        List<Integer> shark_eat = new ArrayList<>();
        int ny = y;
        int nx = x;
        while(true){
            ny = ny + dy[dir];
            nx = nx + dx[dir];
//            System.out.println("y : " + ny + " x : " + nx);
            if(ny >= 0 && nx >= 0 && ny < 4 && nx < 4){
                if(graph[ny][nx] != -1 && graph[ny][nx] != -2){
                    shark_eat.add(graph[ny][nx]);
                }
            }else{
                return shark_eat;
            }
        }
    }


}