import java.util.Arrays;
import java.util.Scanner;

public class baek_1149_RGB거리_실버1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][3];
		for(int i=0; i<N; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
		}
		int[][] dp = new int[3][N];
		dp[0][0] = map[0][0];
		dp[1][0] = map[0][1];
		dp[2][0] = map[0][2];
		
		for(int i=1; i<N; i++) {
			dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1])+map[i][0];
			dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1])+map[i][1];
			dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1])+map[i][2];
		}
		int min = Math.min(dp[0][N-1], Math.min(dp[1][N-1], dp[2][N-1]));
		System.out.println(min);
		
		
	}
}
