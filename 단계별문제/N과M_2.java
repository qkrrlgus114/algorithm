package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_2 {
	// 중복 없이 M개를 고른 수열
	// 고른 수열은 오름차순이어야 한다.
	// 중복되는 수열을 여러 번 출력해서는 안된다.
	static int N; // 1~N까지의 수 결정
	static int M; // 우리가 출력 할 배열의 길이
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		perm(0,0);
	}
	
	public static void perm(int idx,int start) {
		// 종료 조건
		if(idx == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀 조건
		for(int i=start; i<N; i++) {
			// 이미 들렸는지 확인
			if(visited[i]) continue;
			
			// 안들렸으면
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1,i);
			visited[i] = false;
		}
	}
}
