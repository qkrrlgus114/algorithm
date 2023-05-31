package 단계별문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class baek_24479_깊우탐1_실버2 {
	static List<Integer>[] arr;
	static int[] visited;
	static int V;
	static int num = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		int R = sc.nextInt();
		arr = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new int[V+1];
		
		for(int i=0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			arr[st].add(ed);
			arr[ed].add(st);
		}
		
		for(int i = 1 ; i<V+1; i++) {
			Collections.sort(arr[i]);
		}
		
		DFS(R);
		for(int i=1; i<V+1; i++) {
			System.out.println(visited[i]);
		}
	}
	
	public static void DFS(int v) {
		visited[v] = num++;
		Collections.sort(arr[v]);
		for(int i=0; i<arr[v].size(); i++) {
			if(visited[arr[v].get(i)]==0) {
				DFS(arr[v].get(i));
			}
		}
	}
	
	
}
