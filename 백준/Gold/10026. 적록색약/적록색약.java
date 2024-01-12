import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 1 = R, 2 = G, 3 = B
    static boolean[][] visited;
    static int[][] map;
    static int N;
    // 정상인의 결과
    static int ori = 0;
    // 적록색약의 결과
    static int rg = 0;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            char[] sa = bf.readLine().toCharArray();
            for(int j=0; j<N; j++){
                if(sa[j] == 'R'){
                    map[i][j] = 1;
                }else if(sa[j] == 'G'){
                    map[i][j] = 2;
                }else{
                    map[i][j] = 3;
                }
            }
        }

        // 정상인의 결과
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    ori++;
                    // y, x, 색의 값
                    bfs(i, j, map[i][j]);
                }
            }
        }

        // 방문배열 초기화
        visited = new boolean[N][N];
        // G 값을 전부 R로 변경.
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 2){
                    map[i][j] = 1;
                }
            }
        }

        // 적녹색약의 결과
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    rg++;
                    // y, x, 색의 값
                    bfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(ori + " " + rg);
    }

    public static void bfs(int y, int x, int color){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x , color});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];

            for(int i=0; i<4; i++){
                int ndy = y + dy[i];
                int ndx = x + dx[i];
                // 범위 체크
                if(ndy >= 0 && ndx >= 0 && ndx < N && ndy < N){
                    // 색이 같은지 파악
                    if(!visited[ndy][ndx] && color == map[ndy][ndx]){
                        visited[ndy][ndx] = true;
                        q.add(new int[]{ndy, ndx, color});
                    }
                }
            }
        }
    }

}