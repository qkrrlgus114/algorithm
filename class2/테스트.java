package class2;

import java.util.Arrays;
import java.util.Scanner;

public class 테스트 {
	
	static boolean[] visited;
	static int[] arr;
	static int[] result;
	static int N;
	static int M;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		visited = new boolean[N+1];
		result = new int[M];
		sb = new StringBuilder();
		
		back(0, 1);
		System.out.println(sb);
		
	}
	
	public static void back(int depth, int start) {
		// 종료
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀
		for(int i=start; i<N+1; i++) {
			if(visited[i]) continue;
			if(i>1 && arr[i]==arr[i-1] && !visited[i-1]) continue;
			
//			visited[i] = true;
			result[depth] = arr[i];
			back(depth+1, i);
//			visited[i] = false;
		}
	}
}