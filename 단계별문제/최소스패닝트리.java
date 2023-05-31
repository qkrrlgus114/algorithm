package 단계별문제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소스패닝트리 {
	public static class Edge implements Comparable<Edge>{
		int ed;
		int w;
		public Edge( int ed, int w) {
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
			
			list[st].add(new Edge(ed, w)); // 무방향이기때문
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		pq.addAll(list[1]);
		visited[1] = true;
		
		int pick = 1;
		long sum = 0;
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
