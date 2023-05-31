package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_1 {
	// 1. 자연수 N과 M이 주어질 때
	// 중복되는 수열은 여러 번 출력하면 안된다.
	// 수열은 사전 순으로 증가하는 순서로 출략
	static int N; // 1~N까지 자연수
	static int M; // 몇 개를 뽑을 건지
	static int arr[];
	static int result[];
	static boolean visited[];
	
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
		perm(0);
	}
	
	public static void perm(int idx) {
		// 종료 조건
		if(idx == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 재귀 조건
		for(int i=0; i<N ;i++) {
			 // 이미 돌았는지 확인
			if(visited[i]) continue;
			
			result[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
}
