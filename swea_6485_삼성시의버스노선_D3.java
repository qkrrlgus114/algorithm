import java.util.Arrays;
import java.util.Scanner;

public class swea_6485_삼성시의버스노선_D3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int[] count = new int[5001];
			int N = sc.nextInt();
			for(int i=0; i<N; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j=a; j<=b; j++) {
					count[j]++;
				}
			}
			int P = sc.nextInt();
			System.out.printf("#%d ",q);
			for(int i=0; i<P; i++){
				int c = sc.nextInt();
				System.out.printf("%d ",count[c]);
			}
			System.out.println();
		}
	}
}