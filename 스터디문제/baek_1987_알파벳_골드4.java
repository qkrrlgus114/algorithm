package 스터디문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1987_알파벳_골드4 {

	static int H;
	static int W;
	static boolean[] visited; // 방문체크
	static char[][] map; // 입력받기 위한 맵
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max = Integer.MIN_VALUE; // 맥스값 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new char[H][W];
		visited = new boolean[26]; // 알파벳의 개수

		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		dfs(0, 0, 1);
		if(max==Integer.MIN_VALUE) {
			System.out.println(1);
		}else {
		System.out.println(max);
		}
	}
	
	public static int dfs(int x,int y, int cnt) {

		visited[map[x][y]-'A'] = true; // 'A'를 빼야 0부터 시작하기 때문. 그래서 visited를 26칸으로 생성.
		
		// 재귀 조건
		for(int i=0; i<4; i++) {
			int idx = x + dr[i];
			int idy = y + dc[i];
			if(idx>=0 && idy>=0 && idx<H && idy<W) { // 범위에 들어있다면
				if(visited[map[idx][idy]-'A']) { // 이미 true가 됐으면 패스
					continue;
				}
				
				visited[map[idx][idy]-'A'] = true;
				int result = dfs(idx, idy, cnt+1); // 밑에서 cnt가 리턴된다.
				max = Math.max(max, result); // max랑 비교해서 최대값 갱신
			}
		}
		
		visited[map[x][y]-'A'] = false; // 상하좌우 탐색 끝나면 false로 돌리고
		return cnt; // cnt 반환한다.
		
	}
}
