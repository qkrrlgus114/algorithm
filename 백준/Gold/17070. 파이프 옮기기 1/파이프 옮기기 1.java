import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(sa[j]);
            }
        }

        // 오른쪽 = 1, 대각선 = 2, 아래 = 3
        dfs(0, 1, 1);
        System.out.println(result);
    }

    public static void dfs(int y, int x, int dir){
        // 종료 조건
        if(y == N-1 && x == N-1){
            result++;
            return;
        }

        for(int i=0; i<3; i++){
            // 오른쪽
            if((dir == 1 || dir == 2) && i==0 && check(y, x, i)){
                dfs(y, x+1, 1);
            }
            // 아래
            else if((dir == 2 || dir == 3) && i==1 && check(y, x, i)){
                dfs(y+1, x, 3);
            }
            // 대각선
            else if(i==2 && check(y, x, i)){
                dfs(y+1, x+1, 2);
            }
        }
    }

    public static boolean check(int y, int x, int index){
        // 오른쪽 확인
        if(index == 0){
            if(x + 1 < N && map[y][x+1] == 0){
                return true;
            }
        }
        // 아래 확인
        else if(index == 1){
            if(y + 1 < N && map[y+1][x] == 0){
                return true;
            }
        }
        // 대각선 확인
        else{
            if(x + 1 < N && y + 1 < N && map[y+1][x+1] == 0 && map[y+1][x] == 0 && map[y][x+1] == 0){
                return true;
            }
        }
        return false;
    }
}