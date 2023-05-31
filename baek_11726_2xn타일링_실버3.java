import java.util.Arrays;
import java.util.Scanner;

public class baek_11726_2xn타일링_실버3 {
	static long[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new long[N+1];
		if(N<=3) {
			System.out.println(N);
		}else {
			dp[1]=1;
			dp[2]=2;
			dp[3]=3;
			System.out.println(cal(N));
		}
		
	}

	private static long cal(int n) {
		if(dp[n]!=0) {
			return dp[n];
		}else {
			dp[n] = (cal(n-1) + cal(n-2))%10007;
			return dp[n];
		}
	}
}
