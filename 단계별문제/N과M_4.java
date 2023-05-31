package 단계별문제;

import java.util.Scanner;

public class N과M_4 {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		perm(0, 0);
		System.out.println(sb);
	}
	
	public static void perm(int idx, int start) {
		// 종료
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀
		for(int i=start; i<N; i++) {
			if(visited[i]) continue;
			
			result[idx] = arr[i];
			perm(idx+1,i);
		}
	}
}
