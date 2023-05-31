import java.util.Scanner;

public class baek_2167_2차원배열의합_실버5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		for(int q=0; q<K; q++) {
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int sum = 0;
			for(int w=i; w<=x; w++) {
				for(int e=j; e<=y; e++) {
					sum+=arr[w][e];
				}
			}
			System.out.println(sum);
		}
		
	}
}
