package class2;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {
	static Queue<Integer> q;
	static boolean[] visited;
	static List<Integer>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		visited = new boolean[V+1];
		q = new LinkedList<Integer>();		
		
		list = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			list[st].add(ed);
			list[ed].add(st);
		}
		int cnt = 0;
		BFS(1,0);
		
		
	}
	
	public static void BFS(int depth, int cnt) {
		q.add(depth);
		visited[depth] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=0; i<list[curr].size(); i++) {
				int temp = list[curr].get(i);
				if(!visited[temp]) {
					visited[temp] = true;
					q.add(temp);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
