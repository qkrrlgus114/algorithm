package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_6 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static int len;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0,0);
	}
	
	public static void perm(int depth, int start) {
		// 종료 조건
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀 조건
		for(int i=start; i<N; i++) {
			if(visited[i]) continue;
			
			result[depth] = arr[i];
			visited[i] = true;
			perm(depth+1, i);
			visited[i] = false;
		}
	}
}
