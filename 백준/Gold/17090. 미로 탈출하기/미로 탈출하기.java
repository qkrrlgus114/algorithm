import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    static boolean[][] memo;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        int answer = 0;

        graph = new char[N][M];
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            graph[i] = s.toCharArray();
        }
        
        visited = new boolean[N][M];
        memo = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j]) continue;
                dfs(i, j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(memo[i][j]) answer++;
            }
        }

        System.out.println(answer);


    }

    public static boolean dfs(int i, int j){
        if(i < 0 || j < 0 || i >= N || j >= M){
            return true;
        }

        if(visited[i][j]){
            return memo[i][j];
        }

        visited[i][j] = true;

        char dir = graph[i][j];

        if(dir == 'U') memo[i][j] = dfs(i-1, j);
        else if(dir == 'D') memo[i][j] = dfs(i+1, j);
        else if(dir == 'R') memo[i][j] = dfs(i, j+1);
        else if(dir == 'L') memo[i][j] = dfs(i, j-1);

        return memo[i][j];
    }

}

