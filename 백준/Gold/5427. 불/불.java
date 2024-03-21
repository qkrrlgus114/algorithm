import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] visited;
    // 상근이 이동
    static boolean[][] sang_visited;
    static char[][] graph;
    static int result;
    // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    // 초기 불, 상근이 위치
    static List<int[]> list;
    static int[] init_sang = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String t = bf.readLine();
        int T = Integer.parseInt(t);

        for(int q=0; q<T; q++){
            String[] sa = bf.readLine().split(" ");
            M = Integer.parseInt(sa[0]);
            N = Integer.parseInt(sa[1]);
            graph = new char[N][M];
            visited = new int[N][M];
            sang_visited = new boolean[N][M];
            result = 0;
            list = new ArrayList<>();

            for(int i=0; i<N; i++){
                Arrays.fill(visited[i], -1);
            }

            for(int i=0; i<N; i++){
                String s = bf.readLine();
                for(int j=0; j<M; j++){
                    graph[i][j] = s.charAt(j);
                    if(graph[i][j] == '*') list.add(new int[]{i, j});
                    else if(graph[i][j] == '@'){
                        init_sang[0] = i;
                        init_sang[1] = j;
                    }
                }
            }

            // 불 bfs
            fireBfs();
            // 상근이 bfs
            if(init_sang[0] == 0 || init_sang[0] == N-1 || init_sang[1] == 0 || init_sang[1] == M-1){
                System.out.println(1);
            }else{
                sangBfs();


                if(result == 0) System.out.println("IMPOSSIBLE");
                else System.out.println(result);
            }
        }
    }

    public static void fireBfs(){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<list.size(); i++){
            int[] temp =  list.get(i);
            visited[temp[0]][temp[1]] = 0;
            q.add(new int[]{temp[0], temp[1], 0});
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int step = temp[2];
            for(int i=0; i<4; i++){
                int ndx = x + dx[i];
                int ndy = y + dy[i];
                if(ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
                if(visited[ndy][ndx] != -1 || graph[ndy][ndx] == '#') continue;
                visited[ndy][ndx] = step + 1;
                q.add(new int[]{ndy, ndx, step + 1});
            }
        }
    }

    public static void sangBfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{init_sang[0], init_sang[1], 0});

        outer: while(!q.isEmpty()){
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int step = temp[2];
            for(int i=0; i<4; i++){
                int ndx = x + dx[i];
                int ndy = y + dy[i];
                if(ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
                if(graph[ndy][ndx] == '#' || (visited[ndy][ndx] <= step + 1 && visited[ndy][ndx] != -1) || sang_visited[ndy][ndx]) continue;
                // 상근이 탈출 조건
                if(ndx == 0 || ndy == 0 || ndx == M-1 || ndy == N-1){
                    result = step + 2;
                    break outer;
                }
                sang_visited[ndy][ndx] = true;
                q.add(new int[]{ndy, ndx, step + 1});
            }
        }
    }

}

