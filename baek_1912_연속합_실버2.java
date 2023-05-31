import java.util.Arrays;
import java.util.Scanner;

public class baek_1912_연속합_실버2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] memo = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		memo[0] = arr[0];
		for(int i=1; i<N; i++) {
			memo[i] = Math.max(memo[i-1]+arr[i], arr[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(max < memo[i]) max = memo[i];
		}
		System.out.println(max);
	}
}
