import java.util.Arrays;
import java.util.Scanner;

public class swea_부분수열의합_D3 {
	
	public static int[] arr;
	public static boolean[] sel;
	public static int N;
	public static int K;
	public static int count = 0;
	public static int sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			count = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			sel = new boolean[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			cal(0);
			System.out.printf("#%d %d\n",tc,count);
			
		}
	}
	
	public static void cal(int x) {
		// 종료 조건
		if(x == N) {
			sum = 0;
			for(int i=0; i<N; i++) {
				if(sel[i]) {
					sum += arr[i];
				}            
			}
			if(sum == K) {
				count++;
				return;
			}
			return;
		}
		
		
		// 재귀 조건
		sel[x] = true;
		cal(x + 1);
		sel[x] = false;
		cal(x + 1);    
	}
}
