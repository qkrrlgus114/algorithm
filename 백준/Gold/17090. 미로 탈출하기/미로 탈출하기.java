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
    static int[][] memo;
    static int answer = 0;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        graph = new char[N][M];
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            graph[i] = s.toCharArray();
        }
        
        visited = new boolean[N][M];
        memo = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(memo[i][j] == 0){
                    resetVisited();
                    boolean result = dfs(i, j);
                    if(result) answer++;
                }else if(memo[i][j] == 1){
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    public static boolean dfs(int i, int j){
        if(i < 0 || i >= N || j < 0 || j >= M){
            qAdd(true);
            return true;
        }

        // 메모 배열 확인
        if(memo[i][j] == 2) {
            qAdd(false);
            return false;
        }
        else if(memo[i][j] == 1) {
            qAdd(true);
            return true;
        }

        if(visited[i][j]){
            qAdd(false);
            return false;
        }
        visited[i][j] = true;
        q.add(new int[]{i, j});

        char dir = graph[i][j];

        if(dir == 'U') return dfs(i-1, j);
        else if(dir == 'D') return dfs(i+1, j);
        else if(dir == 'R') return dfs(i, j+1);
        else if(dir == 'L') return dfs(i, j-1);

        return false;
    }

    public static void resetVisited(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void qAdd(boolean check){
        // 1이면 탈출가능 경로, 2면 탈출 불가능 경로
        if(check){
            while(!q.isEmpty()){
                int[] temp = q.poll();
                memo[temp[0]][temp[1]] = 1;
            }
        }else{
            while(!q.isEmpty()){
                int[] temp = q.poll();
                memo[temp[0]][temp[1]] = 2;
            }
        }
    }

}

