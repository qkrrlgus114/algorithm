package 단계별문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_2644_촌수계산_실버2 {
	
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] result;
	static int cnt = 0;
	static int search1;
	static int search2;
	static int max;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		// 두 개의 비교할 촌수를 받음.
		max = sc.nextInt(); 
		min = sc.nextInt();
		// 
		max = Math.max(max, min);
		min = Math.min(max, min);
		int E = sc.nextInt();
		result = new int[101];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1; i<=E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			list[st].add(ed);
			list[ed].add(st);
		}
		BFS(max);
		if(result[min]==0) {
			System.out.println(-1);
		}else {
			System.out.println(result[min]);
		}
		
		
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true; // 방문 체크
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=0; i<list[curr].size(); i++) {
				int temp = list[curr].get(i);
				if(visited[temp]) continue;
				visited[temp] = true;
				result[temp] = result[curr] + 1;
				if(temp==min) {
					return;
				}
				q.add(temp);
			}
		}
	}
}
