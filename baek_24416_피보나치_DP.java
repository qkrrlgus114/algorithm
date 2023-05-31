import java.util.Scanner;

public class baek_24416_피보나치_DP {
	static int[] memo;
	static int cnt=-1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new int[N+1];
		System.out.print(fibonacci(N)+" "+cnt);
	}

	private static int fibonacci(int n) {
		if(n<=1) {
			return n;
		} else if(memo[n]!=0) {
			return memo[n];
		} else {
			cnt++;
			return memo[n] = fibonacci(n-2)+fibonacci(n-1);
		}
		
	}
}
