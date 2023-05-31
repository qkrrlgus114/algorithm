package 단계별문제;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_1260_dfsbfs_실버2 {
	static int N;
	static int M;
	static int R;
	static Queue<Integer> q;
	static List<Integer>[] arr;
	static boolean[] visited;
	static int num = 1;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		q = new LinkedList<Integer>();
		visited = new boolean[N+1];
		result = new int[N+1];
		arr = new LinkedList[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = new LinkedList<>();
		}
		
		for(int i=0; i<M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			arr[st].add(ed);
			arr[ed].add(st);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(arr[i]);
		}
		// dfs 시작
		DFS(R);
		
		for(int i=1; i<N+1; i++) {
			if(result[i]!=0) System.out.print(result[i]+" ");
			else break;
		}
		System.out.println();
		// 다시 초기화
		num = 1;
		visited = new boolean[N+1];
		result = new int[N+1];
		
		// bfs 시작
		BFS(R);
		
		for(int i=1; i<N+1; i++) {
			if(result[i]!=0) System.out.print(result[i]+" ");
			else break;
		}
		
	}
	public static void DFS(int v) {
		visited[v] = true;
		result[num++] = v;
		for(int i=0; i<arr[v].size(); i++) {
			int temp = arr[v].get(i);
			if(!visited[temp]) {
				DFS(temp);
			}
		}
	}
	
	public static void BFS(int v) {
		q.add(v);
		visited[v] = true;
		result[num++] = v;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=0; i<arr[curr].size(); i++) {
				int temp = arr[curr].get(i);
				if(!visited[temp]) {
					visited[temp] = true;
					result[num++] = temp;
					q.add(temp);
				}
			}
		}
	}
}
