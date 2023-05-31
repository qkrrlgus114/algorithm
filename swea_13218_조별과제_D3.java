import java.util.Scanner;

public class swea_13218_조별과제_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			System.out.printf("#%d %d\n",tc,n/3);
		}
	}
}
