package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_5 {
	static int N;
	static int M;
	static int[] map;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N];
		result = new int[M];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			map[i] = sc.nextInt();
		}
		Arrays.sort(map);
		perm(0);
	}
	
	public static void perm(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");				
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			result[depth] = map[i];
			visited[i] = true;
			perm(depth+1);
			visited[i] = false;
		}
	}
}
