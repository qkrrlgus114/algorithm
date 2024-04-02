import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> cheese = new ArrayList<>();
    // 정답
    static int count = 0;
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] graph;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        graph = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }

        while(true){
            boolean check = false;
            // 빈 공간 체크
            spaceCheck();
//            for(int i=0; i<N; i++){
//                for(int j=0; j<M; j++){
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            // 치즈 체크
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(graph[i][j] == 1 && !visited[1][i][j]){
                        cheeseCheck(i, j);
                        check = true;
                    }
                }
            }

            if(!check){
                break;
            }
            cheeseRemove();
            count++;
        }
        System.out.println(count);
        System.out.println(cheese.get(cheese.size() - 1));

    }

    // 바깥 공간 체크
    public static void spaceCheck(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0][0] = true;
        graph[0][0] = 3;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(visited[0][ndy][ndx] || graph[ndy][ndx] != 0) continue;
                visited[0][ndy][ndx] = true;
                graph[ndy][ndx] = 3;
                q.add(new int[]{ndy, ndx});
            }
        }
    }

    // 치즈 체크
    public static void cheeseCheck(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[1][y][x] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(visited[1][ndy][ndx] && graph[ndy][ndx] == 1) continue;
                if(graph[ndy][ndx] == 3){
                    graph[y][x] = 2;
                }else if(graph[ndy][ndx] == 1 && visited[1][ndy][ndx]){
                    visited[1][ndy][ndx] = true;
                    q.add(new int[]{ndy, ndx});
                }
            }
        }
    }

    // 치즈 삭제
    public static void cheeseRemove(){
        int count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[0][i][j] = false;
                visited[1][i][j] = false;
                if(graph[i][j] == 2){
                    graph[i][j] = 0;
                    count++;
                }
                if(graph[i][j] == 3) graph[i][j] = 0;
            }
        }

        cheese.add(count);
    }
}



