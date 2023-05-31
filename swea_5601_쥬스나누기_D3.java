import java.util.Scanner;

public class swea_5601_쥬스나누기_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			System.out.printf("#%d",tc);
			for(int i=0; i<N; i++) {
				System.out.printf(" %d/%d",1,N);
			}
			System.out.println();
		}
	}
}
