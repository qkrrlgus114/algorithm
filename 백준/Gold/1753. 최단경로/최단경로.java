import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static List<Edge>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        V = Integer.parseInt(sa[0]);
        E = Integer.parseInt(sa[1]);
        list = new List[V + 1];
        for(int i=0; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        int x = Integer.parseInt(bf.readLine());
        for(int i=0; i<E; i++){
            sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            int value = Integer.parseInt(sa[2]);

            list[start].add(new Edge(end, value));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        dijkstra(x);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dijkstra(int x){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(x, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            for(Edge next : list[cur.node]){
                int nextNode = next.node;
                int nextValue = next.value + cur.value;

                if(dist[nextNode] > nextValue){
                    dist[nextNode] = nextValue;
                    pq.add(new Edge(nextNode, nextValue));
                }
            }
        }
    }

}

class Edge implements Comparable<Edge>{
    int node;
    int value;

    public Edge(int node, int value){
        this.node = node;
        this.value  = value;
    }

    public int compareTo(Edge edge){
        return this.value - edge.value;
    }
}