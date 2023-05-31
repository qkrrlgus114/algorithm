import java.util.Arrays;
import java.util.Scanner;

public class baek_11053_가장긴증가하는부분수열_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		dp[0] = 1;
		
		for(int i=1; i<N; i++) {
			int temp = 0;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					temp = Math.max(temp, dp[j]);
				}
			}
			dp[i] = temp+1;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(max < dp[i]) max = dp[i];
		}
		System.out.println(max);
	}
}
