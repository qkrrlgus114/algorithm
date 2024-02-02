import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int N;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int eat, time = 0;
    static int size = 2;
    static Queue<int[]> q = new LinkedList<>();
    static int init_y, init_x = 0;
    static boolean finish = false;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();

        N = Integer.parseInt(n);
        graph = new int[N][N];

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(sa[j]);
                if(graph[i][j] == 9){
                    init_y = i;
                    init_x = j;
                }
            }
        }
        while(true){
            bfs(init_y, init_x);
            if(finish) break;
        }

    }

    public static void bfs(int y, int x){
        ArrayList<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        visited[y][x] = true;
        graph[y][x] = 0;
        q.add(new int[]{y, x, 0});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int move = temp[2];
            for(int i=0; i<4; i++){
                int ndx = x + dx[i];
                int ndy = y + dy[i];
                if(ndx >= 0 && ndy >= 0 && ndx < N && ndy < N){
                    if(graph[ndy][ndx] <= size && !visited[ndy][ndx]){
                        visited[ndy][ndx] = true;
                        q.add(new int[]{ndy, ndx, move + 1});
                        // 현재 위치가 물고기이고 아기상어가 먹을 수 있다면
                        if(graph[ndy][ndx] >= 1 && graph[ndy][ndx] <= 6 && graph[ndy][ndx] < size){
                            list.add(new int[]{ndy, ndx, move + 1});
                        }

                    }
                }
            }
        }

        // 먹을 물고기가 없다면
        if(list.isEmpty()){
            System.out.println(time);
            finish = true;
            return;
        }

        // 물고기를 돌면서 1. 가장 가까움, 2. 위에 있음, 3. 왼쪽에 있음 -> 3가지 기준을 순서대로 봐서 맞는 물고기 찾아야함.
        int[] fish = list.get(0);
        for(int i=1; i<list.size(); i++){
            // 거리가 가까운 물고기가 있다면
            if(fish[2] > list.get(i)[2]){
                fish = list.get(i);
            }
            // 만약에 거리가 같다면
            else if(fish[2] == list.get(i)[2]){
                // 위에 있는지 먼저 확인.
                if(fish[0] > list.get(i)[0]){
                    fish = list.get(i);
                }
                // y축도 같다면
                else if(fish[0] == list.get(i)[0]){
                    // 왼쪽에 있는지 확인
                    if(fish[1] > list.get(i)[1]) fish = list.get(i);
                }
            }
        }

        // 이동거리 더하고, 먹이 + 1
        time += fish[2];
        eat++;

        // 아기상어의 크기와 먹은 횟수가 같으면
        // 상어 사이즈 +1, 먹이 0으로 초기화
        if(eat == size){
            size++;
            eat = 0;
        }

        // 해당 지점 먹었으니 0으로
        graph[fish[0]][fish[1]] = 0;
        init_x = fish[1];
        init_y = fish[0];


    }


}