import java.util.Scanner;

public class swea_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int[] dr = {0,1,1};
			int[] dc = {1,1,0};
			int summax = 0;
			int sum = 0;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					sum = 0;
					for(int l=i; l<M+i; l++) {
						for(int k=j; k<M+j; k++) {
							sum+=map[l][k];
						}
					}
					if(summax<sum) summax = sum;
				}
			}
			System.out.printf("#%d %d\n",q,summax);
		}
	}
}
