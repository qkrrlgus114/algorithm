package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2468_안전영역_실버1 {
	static int N;
	static Queue<Integer> qx;
	static Queue<Integer> qy;
	static boolean[][] visited; // 방문 체크
	static int[][] map; // 맵
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int cnt = 0; // 카운트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE; // 주어진 입력에서 최대를 찾음
		N = sc.nextInt();
		qx = new LinkedList<Integer>();
		qy = new LinkedList<Integer>();
		visited = new boolean[N][N];
		map = new int[N][N];
		// 맵에 입력 받음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				// 맥스를 비교
				if(max<map[i][j]) max = map[i][j];
			}
		}
		int maxcnt = Integer.MIN_VALUE;// 안 잠기는 최대 지역 개수
		for(int w=1; w<=max; w++) { // 1부터 max까지 쭉 돌려봄
			cnt = 0;
			visited = new boolean[N][N]; // 계속 방문쳌 생성해서 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// w보다 크거나 같고 false면 보겠다.
					if (map[i][j] >= w && !visited[i][j]) {
						visited[i][j] = true;
						BFS(i, j, w); // bfs 돌기 시작, w를 같이 넣음
					}
				}
			}
			// 비교해서 교체
			if(maxcnt<cnt) maxcnt = cnt;
		}
		System.out.println(maxcnt);
	}

	public static void BFS(int y, int x, int max) {
		qx.add(x);
		qy.add(y);
		cnt++;
		while (!qx.isEmpty()) {
			int idc = qx.poll();
			int idr = qy.poll();
			// 사방을 전부 탐색
			for (int i = 0; i < 4; i++) {
				int nr = idr + dr[i];
				int nc = idc + dc[i];
				// 경계선 확인
				if (nc >= 0 && nr < N && nr >= 0 && nc < N) {
					// max보다 크거나 같으면 
					if (map[nr][nc] >= max && !visited[nr][nc]) {
						qx.add(nc);
						qy.add(nr);
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
