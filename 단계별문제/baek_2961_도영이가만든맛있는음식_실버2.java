package 단계별문제;

import java.util.Arrays;
import java.util.Scanner;

public class baek_2961_도영이가만든맛있는음식_실버2 {
	static int N;
	static int[] S;
	static int[] B;	
	static int min = Integer.MAX_VALUE;
	static int sum = 0;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		B = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		
		powerset(0);
		System.out.println(min);

	}

	public static void powerset(int depth) {
		// 종료
		if(depth==N) {
			boolean flag = true;
			int s = 0;
			int b = 0;
			for(int i=0; i<N; i++) {
				if(visited[i] && flag==true) {
					s = S[i];
					b = B[i];
					flag = false;
				} else if(visited[i] && flag==false) {
					s *= S[i];
					b += B[i];
				}
			}
			if(s!=0 && b!=0) {
				sum = Math.abs(s-b);				
			}
			if(min>sum) min = sum;
			return;
		}
		
		// 재귀
		visited[depth] = true;
		powerset(depth+1);
		
		visited[depth] = false;
		powerset(depth+1);
	}
}
