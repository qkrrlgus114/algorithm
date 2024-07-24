import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Edge>[] graph;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        graph = new List[N + 1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            int value = Integer.parseInt(sa[2]);

            graph[start].add(new Edge(end, value));
            graph[end].add(new Edge(start, value));
        }

        for(int i=0; i<graph.length; i++){
            Collections.sort(graph[i]);
        }

        prem();

        System.out.println(answer);
    }

    public static void prem(){
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int to = edge.to;
            int value = edge.value;

            if(visited[to]) continue;
            visited[to] = true;
            answer += value;

            for(Edge next : graph[to]){
                if(!visited[next.to]) pq.add(new Edge(next.to, next.value));
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int to;
    int value;

    public Edge(int to, int value){
        this.to = to;
        this.value = value;
    }

    public int compareTo(Edge edge){
        return this.value - edge.value;
    }
}