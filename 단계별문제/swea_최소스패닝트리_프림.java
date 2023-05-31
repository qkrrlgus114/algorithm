package 단계별문제;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class swea_최소스패닝트리_프림 {
	public static class Edge implements Comparable<Edge> {
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
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			List<Edge>[] arr = new ArrayList[V + 1];
			
			for(int i=0; i<V+1; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int i=0; i<E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int C = sc.nextInt();
				
				arr[A].add(new Edge(A, B, C));
				arr[B].add(new Edge(B, A, C));
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			boolean[] visited = new boolean[V+1];
			
			pq.addAll(arr[1]);
			visited[1] = true;
			
			int pick = 1;
			long sum = 0;
			
			while(pick!=V) {
				Edge e = pq.poll();
				if(visited[e.ed]) continue;
				
				visited[e.ed] = true;
				sum += e.w;
				pq.addAll(arr[e.ed]);
				pick++;
			}
			
			System.out.printf("#%d %d\n", tc,sum);
		}
	}
}
