import java.util.Arrays;
import java.util.Scanner;

public class baek_12865_평범한배낭_골드5 {
	static int N; // 아이템 수
	static int K; // 최대 배낭의 무게
	static int[][] item; // 아이템 무게, 가치 
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		item = new int[N+1][2]; // 아이템의 무게,가치를 저장.
		dp = new int[N+1][K+1]; // dp 배열을 하나 만듦.(아이템마다 최대 무게까지 가능한 값을 저장)
		// 입력 받음
		for(int i=1; i<=N; i++) {
			item[i][0] = sc.nextInt();
			item[i][1] = sc.nextInt();
		}
		dpppp();
		// 최댓값 찾기
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(dp[i][j]>max) max = dp[i][j];
			}
		}
		System.out.println(max);
		
	}
	
	public static void dpppp() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				// 2가지 경우로 나눌 수 있다.
				// (1) 현재 최대 무게에서 아이템의 무게를 뺐을 때 0 이상인 경우.
				// (2) 현재 최대 무게에서 아이템의 무게를 뺐을 때 0 미만인 경우.
				if(j-item[i][0] >= 0) {
					// dp에 이전 아이템이 가질 수 있는 최댓값(이전 값이니 dp에서 뽑아낸다) vs 현재 자신의 값 + 이전 값에서 현재 무게를 넘지 않는 최댓값
					dp[i][j] = Math.max(dp[i-1][j], item[i][1]+dp[i-1][j-item[i][0]]);
				}else {
					// dp에 이전 아이템이 가질 수 있는 최댓값을 저장.
					dp[i][j] = dp[i-1][j];
				}
			}
		}
	}
}
