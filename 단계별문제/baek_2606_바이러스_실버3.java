package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_2606_바이러스_실버3 {
	static int V;
	static int E;
	static boolean[] visited;
	static List<Integer>[] arr;
	static Queue<Integer> q;
	static int num = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		visited = new boolean[V+1];
		q = new LinkedList<>();
		arr = new LinkedList[V+1];
		for(int i=0; i<V+1; i++) {
			arr[i] = new LinkedList<>();
		}
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			arr[st].add(ed);
			arr[ed].add(st);
		}
		BFS(1);
		for(int i=2; i<V+1; i++) {
			if(visited[i]) num++;
		}
		System.out.println(num);
		
		
	}
	
	public static void BFS(int v) {
		q.add(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=0; i<arr[curr].size(); i++) {
				int temp = arr[curr].get(i);
				if(!visited[temp]) {
					visited[temp] = true;
					q.add(temp);
				} 
			}
		}
	}
}
