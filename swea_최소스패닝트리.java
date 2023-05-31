import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class swea_최소스패닝트리 {
	public static class Edge implements Comparable<Edge>{
		int st;
		int ed;
		int w;
		public Edge(int ed, int w) {
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
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			List<Edge>[] list = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				int w = sc.nextInt();
				
				list[st].add(new Edge(ed, w));
				list[ed].add(new Edge(st, w));
			}
			
			boolean[] visited = new boolean[V+1];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.addAll(list[1]);
			visited[1] = true;
			
			long sum = 0;
			int pick = 1;
			
			while(pick!=V) {
				Edge e = pq.poll();
				if(visited[e.ed]) continue;
				
				visited[e.ed] = true;
				sum += e.w;
				pq.addAll(list[e.ed]);
				pick++;
			}
			
			System.out.printf("#%d %d\n",tc,sum);
		}
	}
}
