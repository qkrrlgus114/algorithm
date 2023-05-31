package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_11 {
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	
	public static void perm(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			if(i>0 && arr[i]==arr[i-1] && !visited[i-1]) continue;
			
			result[depth] = arr[i];
			perm(depth+1);
		}
	}
}
