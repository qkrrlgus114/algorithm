package 단계별문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class N과M_3 {
	// 같은 수를 여러 번 골라도 된다(중복 가능)
	// 모든 경우의 수를 뽑아내라는 것 같다.
	
	static int N; // 1~N까지의 수를 받겠다
	static int M; // 우리가 출력할 배열의 길이
	static int[] arr;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		perm(0);
		System.out.print(sb);
	}
	
	public static void perm(int idx) {
		// 종료 조건
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀 조건
		for(int i=0; i<N; i++) {
			
			result[idx] = arr[i];
			perm(idx+1);
		}
	}
}
