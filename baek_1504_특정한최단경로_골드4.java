import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_1504_특정한최단경로_골드4 {
	static int[] distance;
	static boolean[] visited;
	static List<Edge>[] list;
	
	public static class Edge implements Comparable<Edge> {
		int to;
		int w;

		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		list = new ArrayList[V + 1]; // 배열 생성
		for (int i = 0; i < V + 1; i++) {
			list[i] = new ArrayList<>(); // 리스트 생성
		}

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int weight = sc.nextInt();
			
			list[st].add(new Edge(ed, weight)); // 무방향이라 2번 넣어줌.
			list[ed].add(new Edge(st, weight));
		}
		
		int v1 = sc.nextInt(); // 지나는 노드1
		int v2 = sc.nextInt(); // 지나는 노드2
			
		int[] disV = dijkstra(1,V); // 1번부터 V까지 다익스트라
		int[] disV1 = dijkstra(v1, V); // v1부터 V까지 다익스트라
		int[] disV2 = dijkstra(v2, V); // v2부터 V까지 다익스트라
		
		long path1 = (long) disV[v1] + disV1[v2] + disV2[V]; // 시작점~v1 + v1에서 v2 + v2~V까지
		long path2 = (long) disV[v2] + disV2[v1] + disV1[V]; // 시작점~v2 + v2에서 v1 + v1~V까지
		
		long min = Math.min(path1, path2); // 가장 최단 경로 택
		
		if(min>=Integer.MAX_VALUE) { // 맥스보다 크면 없다는 뜻.
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	public static int[] dijkstra(int st, int V) {
		distance = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[st] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(st, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.to]) continue;
			visited[e.to] = true;
			
			for(int i=0; i<list[e.to].size(); i++) {
				Edge nextEdge = list[e.to].get(i);
				int next = nextEdge.to;
				int nextw = nextEdge.w;
				
				if(distance[next] > distance[e.to] + nextw) {
					distance[next] = distance[e.to] + nextw;
				}
				pq.add(new Edge(next, distance[next]));
			}
		}
		return distance;
	}
}
