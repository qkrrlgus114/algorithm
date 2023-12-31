import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int M;
    static int V;
    static boolean visited[];
    static List<Integer>[] graph;
    static List<Integer> bfsResult = new ArrayList<>();
    static List<Integer> dfsResult = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        V = Integer.parseInt(s[2]);

        graph = new List[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            graph[start].add(end);
            graph[end].add(start);
        }
        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        bfs();
        visited = new boolean[N + 1];
        dfsResult.add(V);
        visited[V] = true;
        dfs(V);
        for(int i=0; i<dfsResult.size(); i++){
            System.out.print(dfsResult.get(i)+" ");
        }
        System.out.println();
        for(int i=0; i<bfsResult.size(); i++){
            System.out.print(bfsResult.get(i)+" ");
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        bfsResult.add(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < graph[temp].size(); i++) {
                int next = graph[temp].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    bfsResult.add(next);
                    q.add(next);
                }
            }
        }
    }

    public static void dfs(int V){

        for(int i=0; i<graph[V].size(); i++){
            int temp = graph[V].get(i);
            if(!visited[temp]){
                dfsResult.add(temp);
                visited[temp] = true;
                dfs(temp);
            }
        }
    }
}