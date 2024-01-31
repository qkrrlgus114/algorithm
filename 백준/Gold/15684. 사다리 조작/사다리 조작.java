import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static int[][] ladder;
    static int N;
    static int M;
    static int H;
    static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        H = Integer.parseInt(sa[2]);

        ladder = new int[H+2][N+2];

        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            // 사다리의 세로 위치
            int a = Integer.parseInt(sa[0]);
            // 가로선을 놓을 출발 위치
            int b = Integer.parseInt(sa[1]);
            ladder[a][b] = 1;
        }

        dfs(0, 1);
        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }


    }

    public static void dfs(int count, int y){
        // 3이 넘으면 종료
        if(count >= result || count >= 4){
            return;
        }
        // 사다리 체크
        if(check()){
            result = count;
            return ;
        }


        for(int i=y; i<H+2; i++){
            for(int j=1; j<N+1; j++){
                // 사다리 놓기 가능
                if(ladder[i][j] == 0 && ladder[i][j-1] == 0 && ladder[i][j+1] == 0){
                    ladder[i][j] = 1;
                    dfs(count + 1, i);
                    ladder[i][j] = 0;
                }
            }
        }

    }

    public static boolean check(){
        boolean ladder_check = true;

        for(int j=1; j<=N; j++){
            int init_j = j;
            int i = 1;
            while(true){
                // 마지막 도착지라면
                if(i == H+1){
                    if(init_j != j) ladder_check = false;
                    break;
                }
                // 현재 위치가 왼쪽으로 이동하는 사다리라면
                else if(ladder[i][j-1] == 1){
                    i += 1;
                    j -= 1;
                }
                // 현재 위치가 오른쪽으로 이동하는 사다리라면
                else if(ladder[i][j] == 1){
                    i += 1;
                    j += 1;
                }
                // 아래로 내려갈 수 있으면
                else if(ladder[i][j] == 0){
                    i += 1;
                }
            }
            if(!ladder_check) return false;
        }
        return true;
    }

}