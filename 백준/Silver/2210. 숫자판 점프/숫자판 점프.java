import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph = new int[5][5];
    static int answer = 0;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<5; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                sb.append(graph[i][j]);
                dfs(i, j, 1);
                sb.setLength(0);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int y, int x, int count){
        // 종료 조건
        if(count == 6){
            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                answer++;
            }
            return;
        }

        // 재귀 조건
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            sb.append(graph[ny][nx]);
            dfs(ny, nx, count + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
