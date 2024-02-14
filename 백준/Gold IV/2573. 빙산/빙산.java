
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N;
    static int M;
    // 현재 빙산
    static int[][] graph;
    // 삭제될 빙산의 층을 저장
    static int[][] remove;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");

        int year = 0;
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        graph = new int[N][M];
        remove = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            inputs = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }


        while(true){
            // 0이 아닌 빙산이 있는지 확인
            boolean zeroCheck = false;
            // 전체 빙산의 개수
            int ice_count = 0;
            // 전체 빙산의 개수 파악
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(graph[i][j] != 0 && !visited[i][j]){
                        zeroCheck = true;
                        bfs(i, j);
                        ice_count++;
                    }
                }
            }

            // 빙산이 2개 이상이면 종료.
            if(ice_count >= 2){
                System.out.println(year);
                break;
            }
            // 빙산이 다 녹았으면 종료
            else if(!zeroCheck){
                System.out.println(0);
                break;
            }
            // 삭제할 빙산의 개수 파악
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(graph[i][j] != 0) removeCheck(i, j);
                }
            }

            // 전체 돌면서 빙산 삭제
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(remove[i][j] > graph[i][j]) graph[i][j] = 0;
                    else graph[i][j] -= remove[i][j];
                    remove[i][j] = 0;
                    visited[i][j] = false;
                }
            }

            year++;
        }

    }

    // 삭제할 빙산의 개수 파악
    public static void removeCheck(int y, int x){
        int count = 0;

        for(int i=0; i<4; i++){
            int ndx = x + dx[i];
            int ndy = y + dy[i];
            if(ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
            if(graph[ndy][ndx] == 0) count++;
        }

        remove[y][x] = count;
    }

    // 전체 빙산 파악
    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;
                if(ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
                if(graph[ndy][ndx] != 0 && !visited[ndy][ndx]){
                    q.add(new int[]{ndy, ndx});
                    visited[ndy][ndx] = true;
                }
            }
        }


    }
}
