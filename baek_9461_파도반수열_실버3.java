import java.util.Scanner;

public class baek_9461_파도반수열_실버3 {
	static long[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			memo = new long[N+1];
			if(N>3) {
				memo[0]=1;
				memo[1]=1;
				memo[2]=1;
			}
			System.out.println(p(N));
		}
	}

	private static long p(int n) {
		if(n<=3) {
			return 1;
		}else if(memo[n]!=0){
			return memo[n];
		}else {
		return memo[n] = p(n-2) + p(n-3);
		}
	}

	
}