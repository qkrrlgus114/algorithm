import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // 상~
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] graph;
    static boolean[][] visited;
    static int w;
    static int h;



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] sa = bf.readLine().split(" ");
            w = Integer.parseInt(sa[0]);
            h = Integer.parseInt(sa[1]);
            // 섬의 개수
            int result = 0;
            if(w == 0 && h == 0) break;

            graph = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                sa = bf.readLine().split(" ");
                for(int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(sa[j]);
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(graph[i][j] == 1 && !visited[i][j]){
                        bfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }

    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<8; i++){
                int ndy = y + dy[i];
                int ndx = x + dx[i];
                if(ndy >= 0 && ndx >= 0 && ndy < h && ndx < w){
                    if(!visited[ndy][ndx] && graph[ndy][ndx] == 1) {
                        visited[ndy][ndx] = true;
                        q.add(new int[]{ndy, ndx});
                    }
                }
            }
        }
    }

}
