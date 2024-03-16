import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int N, M, V;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        V = Integer.parseInt(sa[2]);
        visited = new boolean[N+1];

        graph = new List[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=0; i<N+1; i++){
            Collections.sort(graph[i]);
        }

        sb.append(V).append(" ");
        visited[V] = true;
        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        sb.append(V).append(" ");
        bfs(V);

        System.out.println(sb);

    }

    public static void dfs(int depth){

        for(int i=0; i<graph[depth].size(); i++){
            int temp = graph[depth].get(i);
            if(!visited[temp]){
                visited[temp] = true;
                sb.append(temp).append(" ");
                dfs(temp);
            }
        }
    }

    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.add(n);

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=0; i<graph[temp].size(); i++){
                int next = graph[temp].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
                sb.append(next).append(" ");
            }
        }

    }

}