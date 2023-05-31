import java.util.Scanner;

public class swea_햄버거다이어트_D3 {
	public static int N; // 재료의 수
	public static int L; // 칼로리 제한
	public static int[][] calo;
	public static boolean[] sel;
	public static int max = Integer.MIN_VALUE;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			max = 0;
			N = sc.nextInt();
			sel = new boolean[N];
			L = sc.nextInt();
			calo = new int[N][2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<2; j++) {
					calo[i][j] = sc.nextInt();
				}
			}
			dropthebeat(0);
			System.out.printf("#%d %d\n",tc,max);
			
			
		}
	}
	
	public static void dropthebeat(int x) {
		// 종료 조건
		if(x == N) {
			int taste = 0;
			int cal = 0;
			for(int i=0; i<N; i++) {
				if(sel[i]) {
					taste += calo[i][0];
					cal += calo[i][1];
				}
			}
			if(cal > L) return;
			else {
				if(max < taste) max = taste;
			}
			return;
		}
		
		
		
		// 재귀 조건
		sel[x] = true;
		dropthebeat(x + 1);
		sel[x] = false;
		dropthebeat(x + 1);
	}
}
