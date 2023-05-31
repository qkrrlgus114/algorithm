import java.util.Scanner;

public class baek_17070_파이프옮기기1_골드5 {
	public static int N;
	public static int[][] map;
	public static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		pipemove(0, 1, 0);
		System.out.println(count);
	}
	
	public static void pipemove(int r, int c, int dir) {
		// 종료 조건
		if(r==N-1 && c==N-1) {
			count++;
			return;
		}
		
		// 재귀 조건
		// 가로로 가는 경우
		if(c+1<N && (dir==0 || dir==1) && map[r][c+1]!=1 ) {
			pipemove(r, c+1, 0);
		}
		// 대각선 가는 경우
		if(c+1<N && r+1<N && map[r+1][c+1]!=1 && map[r][c+1]!=1 && map[r+1][c]!=1) {
			pipemove(r+1, c+1, 1);
		}
		// 세로로 가는 경우
		if(r+1<N && (dir==2 || dir==1) && map[r+1][c]!=1) {
			pipemove(r+1, c, 2);
		}
		
		return;
	}
	
	
}
