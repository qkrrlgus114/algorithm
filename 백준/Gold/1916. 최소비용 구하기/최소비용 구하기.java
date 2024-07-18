import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static int N, M;
    static List<Edge>[] list;
    static int[] dist = new int[1001];
    static boolean[] visited = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        list = new List[N + 1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);
            int value = Integer.parseInt(sa[2]);

            list[start].add(new Edge(end, value));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        String[] sa = bf.readLine().split(" ");
        dijkstra(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]));

        System.out.println(dist[Integer.parseInt(sa[1])]);
    }

    private static void dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        pq.add(new Edge(start , 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curNode = cur.node;
            int curValue = cur.value;
            visited[curNode] = true;

            for(Edge next : list[curNode]){
                int nextNode = next.node;
                int nextValue = next.value + curValue;
                if(visited[nextNode]) continue;

                if(dist[nextNode] > nextValue){
                    dist[nextNode] = nextValue;
                    pq.add(new Edge(nextNode, nextValue));
                }
            }
            if(end == curNode) break;
        }
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