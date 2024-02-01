import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Integer> list = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int result = 0;

        M = Integer.parseInt(sa[0]);
        N = Integer.parseInt(sa[1]);
        K = Integer.parseInt(sa[2]);


        graph = new int[M][N];
        visited = new boolean[M][N];

        for(int q=0; q<K; q++){
            sa = bf.readLine().split(" ");
            // 영역의 개수 카운트
            int count = 0;

            int x1 = Integer.parseInt(sa[0]);
            int y1 = Integer.parseInt(sa[1]);
            int x2 = Integer.parseInt(sa[2]);
            int y2 = Integer.parseInt(sa[3]);
            for(int i=M-y2; i<M-y1; i++){
                for(int j=x1; j<x2; j++){
                    graph[i][j] = 1;
                }
            }
        }


        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j] == 0 && !visited[i][j]){
                    bfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;
        int count = 1;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];

            for(int i=0; i<4; i++){
                int ndx = dx[i] + x;
                int ndy = dy[i] + y;
                if(ndx >= 0 && ndy >= 0 && ndx < N && ndy < M){
                    if(!visited[ndy][ndx] && graph[ndy][ndx] == 0){
                        count++;
                        visited[ndy][ndx] = true;
                        q.add(new int[]{ndy, ndx});
                    }
                }
            }
        }
        list.add(count);
    }


}