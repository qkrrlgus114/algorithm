import java.util.Scanner;

public class swea_장훈이의높은선반 {
	static int N;
	static int[] nums;
	static boolean[] visited; // 방문여부
	static int min; // 최소값
	static int B;
	static int sum = 0; // 합
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			nums = new int[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				nums[i] = sc.nextInt();
			}
			perm(0,0);
			System.out.printf("#%d %d\n",tc,min);
			
		}
	}
	
	public static void perm(int idx, int start) {
		if(idx == N || sum>=B) { // 다 셌거나, sum이 B보다 크면
			if(sum-B < min) min = sum-B;
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(visited[i]) continue;
			
			sum += nums[i]; // 더해줌
			visited[i] = true;
			perm(idx+1, i);
			visited[i] = false;
			sum -= nums[i]; // 다시 빼서 원상복구
		}
	}
}
