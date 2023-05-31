import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_9374_상근이의여행_실버4 {
	
	public static class Edge implements Comparable<Edge>{
		int st;
		int ed;
		int we;
		
		public Edge(int st, int ed, int we) {
			this.st = st;
			this.ed = ed;
			this.we = we;
		}

		@Override
		public int compareTo(Edge o) {
			return this.we - o.we;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			List<Edge>[] list = new ArrayList[V+1];
			for(int i=1; i<V+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				
				list[st].add(new Edge(st, ed, 1));
				list[ed].add(new Edge(ed, st, 1));
			}
			
			boolean[] visited = new boolean[V+1];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			visited[1] = true;
			pq.addAll(list[1]);
			
			int pick = 1;
			int sum = 0;
			
			while(pick!=V) {
				Edge e = pq.poll();
				if(visited[e.ed]) continue;
				
				visited[e.ed] = true;
				pq.addAll(list[e.ed]);
				sum += e.we;
				pick++;
			}
			
			System.out.println(sum);
		}
		
	}
}
