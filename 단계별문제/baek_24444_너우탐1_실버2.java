package 단계별문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class baek_24444_너우탐1_실버2 {
	static int N;
	static int M;
	static int R;
	static int[] visited;
	static Queue<Integer> q;
	static List<Integer>[] arr;
	static int num = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		q = new LinkedList<>();
		N=sc.nextInt();
		M=sc.nextInt();
		R=sc.nextInt();
		visited = new int[N+1];
		arr = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
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
		
		BFS(R);
		for(int i=1; i<N+1; i++) {
			System.out.println(visited[i]);
		}
		
	}
	
	public static void BFS(int v) {
		q.add(v);
		visited[v] = num++;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int i=0; i<arr[curr].size(); i++) {
				int temp = arr[curr].get(i);
				if(visited[temp]==0) {
					q.add(temp);
					visited[temp] = num++;
				}
			}
		}
		
		
	}
}
