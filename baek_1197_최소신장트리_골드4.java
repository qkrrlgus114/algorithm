import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_1197_최소신장트리_골드4{
	
	public static class Edge implements Comparable<Edge>{
		int st;
		int ed;
		int w;
		
		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점
		int E = sc.nextInt(); // 간선
		List<Edge>[] list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<E+1; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int we = sc.nextInt();
			
			list[st].add(new Edge(st, ed, we));
			list[ed].add(new Edge(ed, st, we));
		}
		
		boolean[] visited = new boolean[V+1];
		visited[1] = true;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.addAll(list[1]);
		
		int pick = 1;
		int sum = 0;
		
		while(pick!=V) {
			Edge e = pq.poll();
			if(visited[e.ed]) continue;
			
			visited[e.ed] = true;
			sum += e.w;
			pq.addAll(list[e.ed]);
			pick++;
		}
		
		System.out.println(sum);
	}
}