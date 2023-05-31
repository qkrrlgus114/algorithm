import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class baek_4386_별자리만들기_골드3 {
	
	public static class Edge implements Comparable<Edge>{
		int st;
		int ed;
		double we;
		
		public Edge(int st, int ed, double we) {
			this.st = st;
			this.ed = ed;
			this.we = we;
		}

		@Override
		public int compareTo(Edge o) {
            return Double.compare(this.we, o.we);
        }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = V;
		
		double[] x = new double[V+1];
		double[] y = new double[V+1];
		double[] weight = new double[4952];
		boolean[] visited = new boolean[4952];
		
		List<Edge>[] list = new ArrayList[4952];
		for(int i=0; i<4952; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<V+1; i++) {
			x[i] = sc.nextDouble();
			y[i] = sc.nextDouble();
		}
		
		int cnt = 1;
		for(int i=1; i<V; i++) {
			for(int j=i+1; j<V+1; j++) {
				weight[cnt++] = Math.sqrt(Math.pow((x[j]-x[i]), 2)+Math.pow((y[j]-y[i]), 2));
			}
		}
		
		cnt = 1;
		for(int i=1; i<V; i++) {
			for(int j=i+1; j<V+1; j++) {
				int st = i;
				int ed = j;
				double we = weight[cnt++];
				
				list[st].add(new Edge(st, ed, we));
				list[ed].add(new Edge(ed, st, we));
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[1] = true;
		pq.addAll(list[1]);
		
		int pick = 1;
		double sum = 0;
		while(pick!=V) {
			Edge e = pq.poll();
			if(visited[e.ed]) continue;
			
			sum += e.we;
			visited[e.ed] = true;
			pick++;
			pq.addAll(list[e.ed]);
		}
		
		System.out.printf("%.2f",sum);
	}
}
