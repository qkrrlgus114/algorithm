import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SnakeDir{
    int second;
    String dir;

    public SnakeDir(int second, String dir){
        this.second = second;
        this.dir = dir;
    }
}

public class Main {

    // U = 0, R = 1, D = 2, L = 3
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int seconds = 0;
    static int dir = 1;
    static Queue<SnakeDir> q;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        // 뱀을 담을 deque 생성(first - 머리, last - 꼬리)
        Deque<int[]> dq = new LinkedList<>();
        dq.addFirst(new int[]{0, 0});
        int N = Integer.parseInt(input);
        // 사과를 표시할 2차 맵
        int[][] graph = new int[N][N];
        graph[0][0] = 2;

        // 맵에 사과 담기
        input = bf.readLine();
        int apple_count = Integer.parseInt(input);
        for(int i=0; i<apple_count; i++){
            String[] inputs = bf.readLine().split(" ");
            graph[Integer.parseInt(inputs[0]) - 1][Integer.parseInt(inputs[1]) - 1] = 1;
        }

        // 뱀의 회전 위치 담기
        q = new LinkedList<>();
        input = bf.readLine();
        int snake_rotation = Integer.parseInt(input);
        for(int i=0 ;i<snake_rotation; i++){
            String[] inputs = bf.readLine().split(" ");
            q.add(new SnakeDir(Integer.parseInt(inputs[0]), inputs[1]));
        }

        change_dir();

        while(true){
            int[] head = dq.getFirst();
            // 다음 칸으로 이동 가능한지 먼저 판단
            int y = head[0];
            int x = head[1];
            y += dy[dir];
            x += dx[dir];
            // 벽이거나 뱀의 몸이면 종료
            if(y < 0 || x < 0 || y >= N || x >= N || graph[y][x] == 2) break;

            // 다음 위치에 사과가 있는지 판단
            if(graph[y][x] == 1){
                graph[y][x] = 2;
                dq.addFirst(new int[]{y, x});
            }else{
                graph[y][x] = 2;
                dq.addFirst(new int[]{y, x});
                int[] poll = dq.pollLast();
                graph[poll[0]][poll[1]] = 0;
            }

            seconds++;
            change_dir();
        }

        System.out.println(seconds + 1);

    }


    public static void change_dir(){
        if(!q.isEmpty()){
            SnakeDir peek = q.peek();
            if(seconds == peek.second){
                if("D".equals(peek.dir)){
                    if(dir == 3) dir = 0;
                    else dir++;
                }else{
                    if(dir == 0) dir = 3;
                    else dir--;
                }
                q.poll();
            }
        }
    }
}