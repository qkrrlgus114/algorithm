package 단계별문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class baek_24480_깊우탐2_실버2 {
	static int N;
	static int M;
	static int R;
	static List<Integer>[] arr;
	static int[] visited;
	static int num = 1;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		arr = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		visited = new int[N+1];
		
		for(int i=0; i<M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			arr[st].add(ed);
			arr[ed].add(st);
		}
		
	
		DFS(R);
		for(int i=1; i<N+1; i++) {
			System.out.println(visited[i]);
		}

	}
	
	public static void DFS(int v) {
		visited[v] = num++;
		Collections.sort(arr[v], Collections.reverseOrder());
		for(int i=0; i<arr[v].size(); i++) {
			if(visited[arr[v].get(i)]==0) {
				DFS(arr[v].get(i));
			}
		}
	}
}
