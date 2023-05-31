import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_1753_최단경로_골드4 {
	public static class Edge implements Comparable<Edge>{
		int end;
		int weight;
		
		public Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int st = sc.nextInt();
		
		List<Edge>[] list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			int start = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			
			list[start].add(new Edge(ed, w));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[st] = 0;
		pq.add(new Edge(st, 0));
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int curr = e.end;
			if(visited[curr]) continue;
			for(int i=0; i<list[curr].size(); i++) {
				Edge nextEdge = list[curr].get(i);
				int next = nextEdge.end;
				int weight = nextEdge.weight;
				
			}
		}
		
	}
}
