import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class baek_상근이의여행_실버4 {
	public static class Edge implements Comparable<Edge>{
		int st;
		int ed;
		int w;
		public Edge(int st, int ed, int w) {
			super();
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			List<Edge>[] arr = new ArrayList[V+1];
			for(int i=0; i<V+1; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int W = 0;
				W++;
				arr[A].add(new Edge(A, B, W));
				arr[B].add(new Edge(B, A, W));
			}
			
			boolean[] visited = new boolean[V+1];
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			int pick = 1;
			pq.addAll(arr[1]);
			visited[1] = true;
			
			int num = 0;
			while(pick!=V) {
				Edge e = pq.poll();
				if(visited[e.ed]) continue;
				
				visited[e.ed] = true;
				num++;
				pick++;
				pq.addAll(arr[e.ed]);
				
			}
			System.out.println(num);
		}
	}
}
