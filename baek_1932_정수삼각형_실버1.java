import java.util.Arrays;
import java.util.Scanner;

public class baek_1932_정수삼각형_실버1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int[][] memo = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		memo[0][0] = arr[0][0];
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<=i; j++) {
				memo[i+1][j] = Math.max(memo[i][j]+arr[i+1][j], memo[i+1][j]);
				memo[i+1][j+1] = Math.max(memo[i][j]+arr[i+1][j+1], memo[i+1][j+1]);
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			if(max < memo[N-1][i]) {
				max = memo[N-1][i];
			}
		}
		
		System.out.println(max);
	}
}
