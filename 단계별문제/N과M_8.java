package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_8 {
	static int N;
	static int M;
	static int arr[];
	static int result[];
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0, 0);
		System.out.println(sb);
	}
	
	public static void perm(int depth, int start) {
		// 종료조건
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			
			result[depth] = arr[i];
			perm(depth+1, i);
		}
	}
}
