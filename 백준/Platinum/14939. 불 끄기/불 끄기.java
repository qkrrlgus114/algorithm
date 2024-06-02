import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] light = new boolean[10][10];
    static int answer = Integer.MAX_VALUE;
    // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            String s = bf.readLine();
            for (int j = 0; j < 10; j++) {
                if (s.charAt(j) == 'O') light[i][j] = true;
            }
        }

        dfs(0, 0);
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    private static void dfs(int depth, int count) {

        int y = depth / 10;
        int x = depth % 10;

        if (y == 10) {
            boolean check = true;
            outer: for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    if (light[i][j]){
                        check = false;
                        break outer;
                    }
                }
            }
            if(check){
                answer = Math.min(answer, count);
            }
            return;
        }

        if (y == 0) {
            // 불 켜고
            turnLight(y, x);
            dfs(depth + 1, count + 1); // 선택하고 다음으로
            // 원상복구
            turnLight(y, x);
            dfs(depth + 1, count); // 선택하지 않고 다음으로
        } else {
            // 위에 불이 켜져있으면
            if (light[y - 1][x]) {
                // 불 켜고
                turnLight(y, x);
                dfs(depth + 1, count + 1);
                turnLight(y, x);
            }else{
                dfs(depth + 1, count);
            }
        }
    }

    private static void turnLight(int y, int x) {
        light[y][x] = !light[y][x];
        for (int i = 0; i < 4; i++) {
            int ndy = dy[i] + y;
            int ndx = dx[i] + x;
            if (ndy < 0 || ndx < 0 || ndy >= 10 || ndx >= 10) continue;
            light[ndy][ndx] = !light[ndy][ndx];
        }
    }

}


