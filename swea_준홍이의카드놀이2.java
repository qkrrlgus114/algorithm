import java.util.Scanner;

public class swea_준홍이의카드놀이2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int q=1; q<=T; q++) {
			// 입력 받고
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] Ncard = new int[N];
			int[] Mcard = new int[M];
			System.out.printf("#%d ", q);
			// N이 6이고 M이 8이면 N+1부터 M+1까지가 공통으로 같은 확률을 가진다는 규칙을 찾았다.
			// N과 M 둘 다 4면 N+1~M+1 이므로 5이다.
			if(N<=M) {
				for(int i=N+1; i<=M+1; i++) {
					System.out.print(i+" ");
				}
			}
			else {
				for(int i=M+1; i<=N+1; i++) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}
}
