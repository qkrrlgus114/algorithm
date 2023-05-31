import java.util.Scanner;

public class swea_러시아국기같은깃발2_재귀 {
	static char[][] map;
	static int N, M, min;
	static char[] colors; // 재귀적으로 선택된 행별 색깔을 담을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new char[N][M];
			colors = new char[N]; // 행의 정보만 가지면 되므로
			
			// 2차원 배열 입력받기
			for(int r=0; r<N; r++) {
				String str = sc.next();
				for(int c=0; c<M; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			
			min = Integer.MAX_VALUE; // 최솟값 초기화
			
			// 재귀적으로 행의 색깔을 선택하는 함수
			// 각 선택은 이전 색깔의 영향을 받음
			// select(i) : i번째 행의 색을 선택(x)
			// i번째 행의 선택은 i-1번째 행의 색깔에 의존, 영향을 받음.
			// select(i, prevColor) : i-1번째의 색이 prevColor일 때, i번째 행의 색을 선택
			
			select(1, 'W'); // 1번부터 N-2번까지 선택
			
			// 재귀함수가 다 돌고나면 1번행부터 N-2번행까지 최소값이 min에 저장되어 있어요..
			
			// 0번 행은 어차피 W
			for(int j=0; j<M; j++) {
				if(map[0][j] != 'W') {
					min++;
				}
				// 1번 ~ N-2번까지만 선택하면 됨
				// N-1번 행은 어차피 R
				if(map[N-1][j] != 'R') {
					min++;
				}
			}
			System.out.printf("#%d %d\n",tc,min);
		}
	}
	
	// i-1번째 색이 주어질 때 i번째 색을 선택하는 함수
	// 변수명을 고칠 때 alt + shift + r
	private static void select(int idx, char c) {
		
		// 기저 조건
		if(idx == N-1) { // N-2까지는 선택을 하고, N-1일 때 멈춤.
			// 선택이 완료되었으므로 개수를 셈
			int colorCnt = 0;
			
			for(int i=1; i<N-1; i++) {
				int cnt = 0;
				for(int j=0; j<M; j++) {
					if(map[i][j] != colors[i]) cnt++;
				}
				colorCnt += cnt;
			}
			
			min = (min > colorCnt) ? colorCnt : min;
			
			return;
		}
		
		// i가 N-2번째를 선택하려고 하는데..
		// N-3번째 색이 'W'였으면 => N-2번째는 무조건 'B가 되도록 선택
		if(idx == N-2 && c == 'W') {
			colors[idx] = 'B';
			select(idx+1, 'B');
			return;
		}
		
		// 유도 조건
		if(c == 'W') {
			colors[idx] = 'W';
			select(idx+1, 'W');
			colors[idx] = 'B';
			select(idx+1, 'B');
		}else if(c=='B') {
			colors[idx] = 'B';
			select(idx+1, 'B');
			colors[idx] = 'R';
			select(idx+1, 'R');
		}else if(c=='R') {
			colors[idx] = 'R';
			select(idx+1, 'R');
		}
		
	}
	
	

}
