import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] dir = {4, 2, 4, 4, 1};
    static int min = Integer.MAX_VALUE;
    // cctv의 개수
    static int camCount = 0;
    // cctv의 y, x, type을 담을 배열(cctv는 8개가 제한)
    static int[][] cctv = new int[8][3];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        int index = 0;
        for (int i = 0; i < N; i++) {
            s = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                // cctv의 위치와 타입 저장
                if (map[i][j] != 0 && map[i][j] != 6){
                    cctv[index][0] = i;
                    cctv[index][1] = j;
                    cctv[index][2] = map[i][j] - 1;
                    index++;
                    camCount++;
                }
            }
        }

        dfs(0);
        System.out.println(min);
    }

    public static int[][] copy(int[][] backup, int[][] origin){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                backup[i][j] = origin[i][j];
            }
        }
        return backup;
    }

    public static void dfs(int cam_index){
        if(cam_index == camCount){
            // 사각지대 개수 파악
            int zero_count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 0) zero_count++;
                }
            }

            if(min > zero_count) min = zero_count;
            return;
        }

        int cctv_y = cctv[cam_index][0];
        int cctv_x = cctv[cam_index][1];
        int cctv_type = cctv[cam_index][2];
        int copy_map[][] = new int[N][M];

        for(int i=0; i<dir[cctv_type]; i++){
            // 백업
            copy_map = copy(copy_map, map);
            // cctv_type에 따라 업데이트 함
            if(cctv_type == 0){
                update(cctv_y, cctv_x, i);
            }else if(cctv_type == 1){
                update(cctv_y, cctv_x, i);
                update(cctv_y, cctv_x, i + 2);
            }else if(cctv_type == 2){
                update(cctv_y, cctv_x, i);
                update(cctv_y, cctv_x, i + 1);
            }else if(cctv_type == 3){
                update(cctv_y, cctv_x, i);
                update(cctv_y, cctv_x, i + 1);
                update(cctv_y, cctv_x, i + 2);
            }else if(cctv_type == 4){
                update(cctv_y, cctv_x, i + 1);
                update(cctv_y, cctv_x, i + 2);
                update(cctv_y, cctv_x, i + 3);
                update(cctv_y, cctv_x, i + 4);
            }

            // dfs
            dfs(cam_index + 1);
            // 원본 돌림
            map = copy(map, copy_map);
        }
    }

    public static void update(int cctv_y, int cctv_x, int i){
        i = i % 4;
        // 동쪽 업데이트
        if(i == 0){
            for(int x = cctv_x + 1; x < M; x++){
                if(map[cctv_y][x] == 6) break;
                map[cctv_y][x] = -1;
            }
        }
        // 북쪽 업데이트
        if(i == 1){
            for(int y = cctv_y - 1; y >= 0; y--){
                if(map[y][cctv_x] == 6) break;
                map[y][cctv_x] = -1;
            }
        }
        // 서쪽 업데이트
        if(i == 2){
            for(int x = cctv_x - 1; x >= 0; x--){
                if(map[cctv_y][x] == 6) break;
                map[cctv_y][x] = -1;
            }
        }
        // 남쪽 업데이트
        if(i == 3){
            for(int y = cctv_y + 1; y < N; y++){
                if(map[y][cctv_x] == 6) break;
                map[y][cctv_x] = -1;
            }
        }
    }
}