import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static boolean[][] c_visited;
    static int N;
    static int M;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int result = 0;
    static boolean check = false;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        graph = new int[N][M];


        boolean sc = false;

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
                if(graph[i][j] == 1) sc = true;
            }
        }


        if(sc){
            while(true){
                check = false;
                visited = new boolean[N][M];
                air_change_bfs(0, 0);


                c_visited = new boolean[N][M];
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        if(graph[i][j] == 1 && !c_visited[i][j]){
                            check_cheese(i, j);
                        }
                    }
                }

                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        if(graph[i][j] == 3){
                            check = true;
                            graph[i][j] = 2;
                        }
                    }
                }

                result++;
                if(!check){
                    break;
                }

//            for(int i=0; i<N; i++){
//                System.out.println();
//                for(int j=0; j<M; j++){
//                    System.out.print(graph[i][j] + " ");
//                }
//            }
//            System.out.println();
            }
            System.out.println(result - 1);
        }else{
            System.out.println(0);
        }
    }

    // 외부 공기 2로 변환
    public static void air_change_bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        graph[y][x] = 2;
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndx = x + dx[i];
                int ndy = y + dy[i];
                if(ndx >= 0 && ndy >= 0 && ndx < M && ndy < N){
                    if(!visited[ndy][ndx] && (graph[ndy][ndx] == 0 || graph[ndy][ndx] == 2)){
                        q.add(new int[]{ndy, ndx});
                        visited[ndy][ndx] = true;
                        graph[ndy][ndx] = 2;
                    }
                }
            }
        }
    }

    // 바뀌는 치즈 확인해서 3으로 바꿈
    public static void check_cheese(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        c_visited[y][x] = true;
        q.add(new int[]{y, x});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int cnt = 0;
            for(int i=0; i<4; i++){
                int ndx = x + dx[i];
                int ndy = y + dy[i];
                if(ndx >= 0 && ndy >= 0 && ndx < M && ndy < N){
                    if(!c_visited[ndy][ndx]){
                        if(graph[ndy][ndx] == 1){
                            q.add(new int[]{ndy, ndx});
                            c_visited[ndy][ndx] = true;
                        }else if(graph[ndy][ndx] == 2){
                            cnt++;
                            if(cnt >= 2){
                                graph[y][x] = 3;
                            }
                        }
                    }
                }
            }
        }
    }

}