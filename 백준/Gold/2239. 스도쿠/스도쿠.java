import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    static int[][] graph = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        for(int i=0; i<9; i++){
            String s = bf.readLine();
            for(int j=0; j<9; j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0, 0);

    }

    public static void dfs(int y, int x){
        // 행이 꽉 차면 열 + 1
        if(x == 9){
            dfs(y + 1, 0);
            return;
        }
        // 종료
        if(y == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(graph[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(graph[y][x] == 0){
            for(int i=1; i<=9; i++){
                if(possible(y, x, i)){
                    graph[y][x] = i;
                    dfs(y, x + 1);
                }
            }
            graph[y][x] = 0;
            return;
        }
        dfs(y, x + 1);
    }

    public static boolean possible(int y, int x, int value){
        // 가로 검사
        for(int i=0; i<9; i++){
            if(graph[y][i] == value) return false;
        }
        // 세로 검사
        for(int i=0; i<9; i++){
            if(graph[i][x] == value) return false;
        }
        // 3x3 검사
        for(int i=(y/3) * 3; i<((y/3) * 3) + 3; i++){
            for(int j=(x/3) * 3; j<((x/3) * 3) + 3; j++){
                if(graph[i][j] == value) return false;
            }
        }
        return true;

    }

}



