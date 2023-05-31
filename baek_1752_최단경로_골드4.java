import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_1752_최단경로_골드4 {
	public static class Edge implements Comparable<Edge>{
		int to; // 도착정점
		int w; // 가중치
		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 노드 개수
		int E = sc.nextInt(); // 간선 개수
		int start = sc.nextInt(); // 시작 지점
		
		List<Edge>[] list = new ArrayList[V+1]; //v+1의 배열 생성
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>(); // 배열안에 리스트 생성
		}
		
		for(int i=0; i<E; i++) {
			int st = sc.nextInt(); // 시작 정점
			int ed = sc.nextInt(); // 도착 정점
			int weight = sc.nextInt(); // 가중치
			
			list[st].add(new Edge(ed, weight)); // 각 시작 정점 리스트에 도착 정점과 가중치를 넣음.
		}
		boolean[] visited = new boolean[V+1]; // 방문쳌
		int[] distance = new int[V+1]; // 거리 확인 배열
		Arrays.fill(distance, Integer.MAX_VALUE); // 우선 맥스로 초기화.
		distance[start] = 0; // 시작지점은 0으로 초기화.
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start, 0)); // 처음에 시작지점의 가중치를 넣어줌.
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.to]) continue; // 만약에 도착 정점이 이미 true면 패스
			visited[e.to] = true;
			
			for(int i=0; i<list[e.to].size(); i++) { // 리스트의 사이즈만큼 돌아버렷
				Edge nextEdge = list[e.to].get(i);
				int next = nextEdge.to; 
				int nextw = nextEdge.w;
				
				if(distance[next] > distance[e.to] + nextw) { //만약에 다음 거리가 현재 거리+다음 가중치보다 크면 갱신(더 짧은 거리를 택)
					distance[next] = distance[e.to] + nextw;
				}
				pq.add(new Edge(next, distance[next]));
			}
		}
		
		for(int i=1; i<distance.length; i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
	}
}
