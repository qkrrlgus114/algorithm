import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class swea_하나로_프림 {
	public static class Edge implements Comparable<Edge>{
	    int d; // 거리를 받는다.
	    long c; // 
	    public Edge(int d, long c) {
	        this.d = d;
	        this.c = c;
	    }
	    @Override
	    public int compareTo(Edge o) {
	        return Long.compare(this.c, o.c);
	    }

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			List<Edge>[] list = new ArrayList[N]; // 배열 생성
			for(int i=0; i<N; i++) {
				list[i] = new ArrayList<>(); // 배열 안에 리스트 생성
			}
			
			int[][] arr = new int[N][2]; 
			for(int i=0; i<N; i++) { // x좌표를 받는다.
				arr[i][0] = sc.nextInt();
			}
			for(int i=0; i<N; i++) { // y좌표를 받는다.
				arr[i][1] = sc.nextInt();
			}
			double E = sc.nextDouble();
			
			for(int i=0; i<N; i++) {
				for(int j=i; j<N; j++) {
					long L = (long) (Math.pow(arr[i][0]-arr[j][0], 2)+Math.pow(arr[i][1]-arr[j][1],2)); // 거리 계산
					list[i].add(new Edge(j, L)); // 무방향으로 집어넣음.
					list[j].add(new Edge(i, L));
				}
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N];
			
			pq.addAll(list[0]);
			visited[0] = true;
			
			int pick = 1;
			long sum = 0;
			while(pick!=N) {
				Edge e = pq.poll();
				if(visited[e.d]) continue;
				
				visited[e.d] = true;
				sum += e.c;
				pick++;
				pq.addAll(list[e.d]);
			}
			
			System.out.printf("#%d %d\n",tc,Math.round(sum*E));
		}
	}
}
