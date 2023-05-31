import java.util.Scanner;

public class swea_러시아국기같은깃발_D4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N  = sc.nextInt(); // 행의 수
			int M = sc.nextInt(); // 열의 수
			
			char[][] map = new char[N][M];
			for(int r=0; r<N; r++) {
				String str = sc.next(); // r번째 행의 문자열을 한 행씩 받아오기
				for(int c=0; c<M; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			
			// 최솟값을 구해야 하므로...최대값으로 초기화하고 시작
			int min = Integer.MAX_VALUE;
			
			// b : 파란색(B)가 시작되는 idx
			// r : 빨간색(R)이 시작되는 idx 
			
			// i : 2차원 배열의 행의 idx
			// j : 2차원 배열의 열의 idx
			
			
			// 완전탐색
			for(int b=1; b<N-1; b++) {
				for(int r=2; r<N; r++) {
					// b, r이 정해질 때마다 세 구간이 정해지고
					// 새 구간마다 카운트를 해야 함.
					int cnt = 0;
					
					// [0, b)
					for(int i=0; i<b; i++) {
						for(int j=0; j<M; j++) {
							if(map[i][j]!='W') cnt++;
						}
					}
					
					// [b, r)
					for(int i=b; i<r; i++) {
						for(int j=0; j<M; j++) {
							if(map[i][j]!='B') cnt++;
						}
					}
					
					// [r, N)
					for(int i=r; i<N; i++) {
						for(int j=0; j<M; j++) {
							if(map[i][j] != 'R') cnt++;
						}
					}
					
					
					// 다른 것의 개수가 다 세어진 상황
					// 최소값인지 판단하고 갱신
					if(cnt < min) min = cnt;
				}
			}
			System.out.printf("#%d %d\n",tc,min);
		}
	}
}
