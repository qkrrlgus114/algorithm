import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
* 1. 현재 칸이 청소되지 않으면 청소
* 2. 주변에 청소할 곳이 없다면 현재 방향 유지한채로 후진 -> 1번
* 3. 후진이 불가능하면 멈춤
* 4. 주변에 청소되지 않은 곳이 존재하면
* 5. 반시계 방향으로 회전
* 6. 만약에 그 방향이 청소되지 않았다면 전진 -> 1번
* 7. 청소가 된 구역이면 -> 5번*/

/*
* 0 : 북, 1 : 동, 2 : 남, 3 : 서
* */

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int result = 0;
    // 후진용
    static int[] dby = {1, 0, -1, 0};
    static int[] dbx = {0, -1, 0, 1};
    // 전진용
    static int[] dfy = {-1, 0, 1, 0};
    static int[] dfx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        int init_i = Integer.parseInt(sa[0]);
        int init_j = Integer.parseInt(sa[1]);
        int dir = Integer.parseInt(sa[2]);

        map = new int[N][M];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        clean(init_i, init_j, dir);
        System.out.println(result);
    }

    public static void clean(int y, int x, int dir){
        if (map[y][x] == 0) {
            map[y][x] = 2;
            result++;
        }
        // 주변 탐색 진행
        boolean search = search(y, x, dir);
        // 주변에 청소 가능한 곳이 있다면
        if(search){
            int ndx = 0;
            int ndy = 0;
            for(int i=0; i<4; i++){
                if(dir - 1 == -1){
                    dir = 3;
                }else{
                    dir = dir - 1;
                }
                ndy = y + dfy[dir];
                ndx = x + dfx[dir];
                    if(map[ndy][ndx] == 0){
                        break;
                    }
            }
            // 청소 진행
            clean(ndy, ndx, dir);
        }else{
            // 후진 가능한 상태면
            if(back(y, x, dir)){
                clean(y + dby[dir], x + dbx[dir], dir);
            }
            // 불가능한 상태면
            else{
                return;
            }
        }
    }


    // 주변 탐색(주변에 청소 공간이 있으면 true, 없으면 false 반환)
    public static boolean search(int y, int x, int dir){
        int count = 0;
        for(int i=0; i<4; i++){
            dir = (dir + 1) % 4;
            int ndx = x + dfx[dir];
            int ndy = y + dfy[dir];
                if(map[ndy][ndx] == 0) count++;
        }
        if(count == 0) return false;
        return true;
    }

    // 후진 가능한지 확인
    public static boolean back(int y, int x, int dir) {
        y = y + dby[dir];
        x = x + dbx[dir];
            if (map[y][x] != 1) return true;
            else return false;
    }
}