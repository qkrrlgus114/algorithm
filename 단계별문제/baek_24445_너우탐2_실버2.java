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
import java.util.Queue;


public class baek_24445_너우탐2_실버2 {
	static int N;
	static int M;
	static int R;
	static List<Integer>[] arr;
	static int[] visited;
	static int num = 1;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		q = new LinkedList<>();
		
		arr = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		visited = new int[N+1];
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int st = Integer.parseInt(input[0]);
			int ed = Integer.parseInt(input[1]);
			
			arr[st].add(ed);
			arr[ed].add(st);
		}
		
		BFS(R);
		for(int i=1; i<N+1; i++) {
			bw.write(visited[i]+"\n");
		}
		bw.flush();
		bw.close();
		
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
