import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    /*
    * 두 나라의 인구가 L명 이상 R명 이하면 국경선 열음
    * */

    static int N;
    static int L;
    static int R;
    static int[][] visited;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 인구 이동의 날짜
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        L = Integer.parseInt(sa[1]);
        R = Integer.parseInt(sa[2]);
        graph = new int[N][N];
        visited = new int[N][N];

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
            }
        }

        while(true){
            List<Integer> human = new ArrayList<>();
            List<Integer> united = new ArrayList<>();
            int bfs_index = 1;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j] == 0){
                        int[] bfs = bfs(i, j, bfs_index++);
                        if(bfs[0] != 0){
                            human.add(bfs[0]);
                            united.add(bfs[1]);
                        }
                    }
                }
            }
            if(human.isEmpty()) break;
            int index = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j] != 0){
                        move_bfs(i, j, (int) Math.floor((double) human.get(index) / united.get(index++)), visited[i][j]);
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }

    public static void move_bfs(int y, int x, int val, int posi){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        graph[y][x] = val;
        visited[y][x] = 0;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int temp_y = temp[0];
            int temp_x = temp[1];
            for(int i=0; i<4; i++){
                int ndx = temp_x + dx[i];
                int ndy = temp_y + dy[i];
                if(ndx >= 0 && ndy >= 0 && ndy < N && ndx < N){
                    if(visited[ndy][ndx] != posi) continue;
                    visited[ndy][ndx] = 0;
                    graph[ndy][ndx] = val;
                    q.add(new int[]{ndy, ndx});
                }
            }
        }
    }

    public static int[] bfs(int y, int x, int po){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        int human_count = 0;
        int count = 0;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int temp_y = temp[0];
            int temp_x = temp[1];
            for(int i=0; i<4; i++){
                int ndx = temp_x + dx[i];
                int ndy = temp_y + dy[i];
                if(ndx >= 0 && ndy >= 0 && ndy < N && ndx < N){
                    if(visited[ndy][ndx] != 0) continue;
                    if(Math.abs(graph[temp_y][temp_x] - graph[ndy][ndx]) < L || Math.abs(graph[temp_y][temp_x] - graph[ndy][ndx]) > R) continue;
                    visited[ndy][ndx] = po;
                    q.add(new int[]{ndy, ndx});
                    human_count += graph[ndy][ndx];
                    count++;
                }
            }
        }
        int[] result = new int[2];
        if(human_count != 0){
            result[0] = human_count;
            result[1] = count;
        }

        return result;
    }
}