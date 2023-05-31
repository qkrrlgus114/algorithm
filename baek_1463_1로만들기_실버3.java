import java.util.Arrays;
import java.util.Scanner;

public class baek_1463_1로만들기_실버3 {
	static int[] d;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		d = new int[N + 1];
		if (N > 3) {
			d[1] = 0;
			d[2] = 1;
			d[3] = 1;
		}
		if (N == 1) {
			System.out.println(0);
		} else if (N == 2 || N == 3) {
			System.out.println(1);
		} else {
			System.out.println(dp(N));
		}
	}

	public static int dp(int n) {
		if (d[n] != 0) {
			return d[n];
		} else {
			if (n % 6 == 0) {
				d[n] = Math.min(dp(n/2)+1, Math.min(dp(n/3)+1, dp(n-1)+1));
			} else if (n % 2 == 0) {
				d[n] = Math.min(dp(n/2)+1, dp(n-1)+1);
			} else if (n % 3 == 0) {
				d[n] = Math.min(dp(n/3)+1, dp(n-1)+1);
			} else {
				d[n] = dp(n-1) + 1;
			}
		}
		return d[n];
	}
}
