import javax.sql.rowset.spi.TransactionalWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static int N, E;
    static List<Edge>[] list;
    static int v1, v2;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        E = Integer.parseInt(sa[1]);
        list = new List[N + 1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            int value = Integer.parseInt(sa[2]);

            list[start].add(new Edge(end, value));
            list[end].add(new Edge(start, value));
        }

        sa = bf.readLine().split(" ");
        v1 = Integer.parseInt(sa[0]);
        v2 = Integer.parseInt(sa[1]);

        int one = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int two = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if(one >= INF && two >= INF) System.out.println(-1);
        else{
            System.out.println(Math.min(one, two));
        }
    }

    private static int dijkstra(int start, int end){
        boolean[] visited=  new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        pq.add(new Edge(start , 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curNode = cur.node;
            int curValue= cur.value;
            if(visited[curNode]) continue;
            visited[curNode] = true;
            for(Edge next : list[curNode]){
                int nextNode = next.node;
                int nextValue = next.value + curValue;
                if(visited[nextNode] || dist[nextNode] < nextValue) continue;
                dist[nextNode] = nextValue;
                pq.add(new Edge(nextNode, nextValue));
            }
        }

        return dist[end];
    }
}

class Edge{
    int node;
    int value;

    public Edge(int node, int value){
        this.node = node;
        this.value = value;
    }
}