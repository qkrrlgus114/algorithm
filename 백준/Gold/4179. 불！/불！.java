import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] graph;
    static int[][] fireVisited;
    static int[][] jiVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    static boolean escape = false;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        graph = new char[N][M];
        fireVisited = new int[N][M];
        jiVisited = new int[N][M];
        for(int i=0; i<fireVisited.length; i++){
            Arrays.fill(fireVisited[i], -1);
            Arrays.fill(jiVisited[i], -1);
        }

        int jiY = 0;
        int jiX = 0;
        List<int[]> list = new ArrayList<>();


        for(int i=0; i<N; i++){
            String s = bf.readLine();
            char[] charArray = s.toCharArray();
            for(int j=0; j<charArray.length; j++){
                graph[i][j] = charArray[j];
                if(graph[i][j] == 'J') {
                    jiVisited[i][j] = 0;
                    jiX = j;
                    jiY = i;
                }
                else if(graph[i][j] == 'F'){
                    fireVisited[i][j] = 0;
                    list.add(new int[]{i, j});
                }
            }
        }

        // 불부터 bfs 동작
        fireBFS(list);
        // 지훈이 bfs 동작
        if(jiY == 0 || jiY == N-1 || jiX == 0 || jiX == M-1){
            escape = true;
        }else{
            jiBFS(jiY, jiX);
        }


        if(escape) System.out.println(result + 1);
        else System.out.println("IMPOSSIBLE");

    }

    // 1. 벽으로는 누구도 이동하지 못함
    // 2. 가장자리에 오면 지훈이는 탈출
    // 3. 불은 각 지점에서 네 방향으로 확산
    // 4.

    public static void fireBFS(List<int[]> list){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<list.size(); i++){
            int[] temp = list.get(i);
            q.add(new int[]{temp[0], temp[1]});
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(fireVisited[ndy][ndx] != -1 || graph[ndy][ndx] == '#') continue;
                q.add(new int[]{ndy, ndx});
                fireVisited[ndy][ndx] = fireVisited[y][x] + 1;
            }
        }
    }

    public static void jiBFS(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            boolean check = false;
            for(int i=0; i<4; i++){
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(jiVisited[ndy][ndx] != -1 || graph[ndy][ndx] == '#') continue;
                // 불보다 작아야 이동 가능
                if(jiVisited[y][x] + 1 < fireVisited[ndy][ndx] || fireVisited[ndy][ndx] == -1){
                    q.add(new int[]{ndy, ndx});
                    jiVisited[ndy][ndx] = jiVisited[y][x] + 1;
                    if(ndy == 0 || ndy == N-1 || ndx == 0 || ndx == M-1){
                        result = jiVisited[ndy][ndx];
                        check = true;
                        escape = true;
                        break;
                    }
                }
            }
            if(check) break;
        }
    }
}