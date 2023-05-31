import java.util.Scanner;

public class baek_1051_숫자정사각형_실버4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 델타 배열을 사용해볼까?
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];
		// 입력을 받는다.
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int a = Math.min(N, M)-1;
		int max = 0;
		outer: while(true) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(j+a<M&&i+a<N) {
						if(arr[i][j]==arr[i][j+a]&&arr[i][j]==arr[i+a][j]&&arr[i][j]==arr[i+a][j+a]) {
							break outer;
						}
					}
				}
			}
			a--;
		}
		
		System.out.println((a+1)*(a+1));
	}
}
