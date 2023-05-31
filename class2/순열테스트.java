package class2;

import java.util.Arrays;

public class 순열테스트 {
	static int[] arr;
	static boolean[] visited;
	static int N;
	static int[] result;
	
	public static void main(String[] args) {
		arr = new int[] {1,2,3,4};
		N = arr.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);
		
	}
	
	public static void perm(int depth) {
		if(depth == N) {
			for(int i=0; i<N; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			
			result[depth] = arr[i];
			visited[i] = true;
			perm(depth+1);
			visited[i] = false;
			System.out.println(Arrays.toString(visited));
		}
	}
}
