import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] bridge;
    static boolean[] visited;
    static int N;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        bridge = new int[N+1];
        visited = new boolean[N+1];

        String[] sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            bridge[i] = Integer.parseInt(sa[i-1]);
        }

        sa = bf.readLine().split(" ");

        int start = Integer.parseInt(sa[0]);
        target = Integer.parseInt(sa[1]);

        System.out.println(bfs(start));
    }

    public static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int index = temp[0];
            if(index == target){
                return temp[1];
            }

            for(int i=1; i<=N; i++){
                int front_index = index + (bridge[index] * i);
                int back_index = index - (bridge[index] * i);
                if(front_index >= 1 && front_index <= N){
                    if(!visited[front_index]){
                        q.add(new int[]{front_index, temp[1] + 1});
                        visited[front_index] = true;
                    }
                }
                if(back_index >= 1 && back_index <= N){
                    if(!visited[back_index]){
                        q.add(new int[]{back_index, temp[1] + 1});
                        visited[back_index] = true;
                    }
                }
            }
        }
        return -1;
    }
}
