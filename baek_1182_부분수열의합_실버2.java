import java.util.Scanner;

public class baek_1182_부분수열의합_실버2 {
	static int N;
	static int S;
	static boolean[] visited;
	static int[] arr;
	static int count;
	static int sum;
	static boolean flag = true;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		sum = 0;
		count = 0;
		perm(0, 0);
		System.out.println(count);
	}
	
	public static void perm(int depth, int start) {
		// 종료
		if(flag==false && sum==S) count++;
		
		if(depth == N) {
			return;
		}
		
		// 재귀
		flag = false;
		for(int i=start; i<N; i++) {
			if(visited[i]) continue;
			
			sum+=arr[i];
			visited[i] = true;
			perm(depth+1, i);
			sum-=arr[i];
			visited[i] = false;
		}
	}
}
