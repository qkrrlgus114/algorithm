import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    // 가장 작은 케빈 베이컨
    static int result = Integer.MAX_VALUE;
    // 가장 작은 케빈 베이컨을 가진 사람
    static int result_index = Integer.MAX_VALUE;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        graph = new List[N +1 ];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            inputs = bf.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1; i<=N; i++){
            bfs(i);
        }

        System.out.println(result_index);

    }

    public static void bfs(int t){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{t, 0});
        boolean[] visited = new boolean[N+1];
        visited[t] = true;
        int sum = 0;

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int index = temp[0];
            int count = temp[1];
            for(int i=0; i<graph[index].size(); i++){
                int next = graph[index].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                sum += count + 1;
                q.add(new int[]{next, count + 1});
            }
        }

        if(result > sum){
            result_index = t;
            result = sum;
        }
    }
}