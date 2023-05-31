package 단계별문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2206_벽부수고이동_골드3 {
	public static class Now { // x,y,이동 횟수,벽을 부쉈는지(0,1로 구분)
		int x;
		int y;
		int cnt;
		int wall;

		public Now(int x, int y, int cnt, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.wall = wall;
		}

	}

	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][][] visited; // [x][y][0,1로 벽 부쉈는지]

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visited = new boolean[N][M][2];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		BFS(0, 0, N, M);
		

	}

	public static void BFS(int x, int y, int N, int M) {
		Queue<Now> q = new LinkedList<>();
		q.add(new Now(x, y, 0, 0)); // 처음에는 cnt 0이고 벽도 안부쉈으니 0
		visited[x][y][0] = true;
		while (!q.isEmpty()) {
			Now now = q.poll();
			int cnt = now.cnt + 1; // 1번 이동했다는 의미
			if (now.x == N - 1 && now.y == M - 1) { // 끝에 도달했으면 출력
				System.out.println(cnt);
				return;
			}
			x = now.x;
			y = now.y;
			for (int i = 0; i < 4; i++) { // 사방탐색
				int idx = x + dr[i];
				int idy = y + dc[i];
				if (idx >= 0 && idy >= 0 && idx < N && idy < M) { // 범위 체크
					if (map[idx][idy] == 0) { // 우선 맵에 벽이 없으면
						// 현재 벽을 안 부쉈고, 안 부순 맵에 방문하지 않았다면?
						if (now.wall == 0 && !visited[idx][idy][0]) {
							q.add(new Now(idx, idy, cnt, 0)); // 큐에 넣고
							visited[idx][idy][0] = true; // 방문 체크
							// 현재 벽을 부순 상태고, 부순 맵에 방문하지 않았다면?
						} else if (now.wall == 1 && !visited[idx][idy][1]) {
							q.add(new Now(idx, idy, cnt, 1)); // 큐에 넣고
							visited[idx][idy][1] = true; // 방문체크
						}
						// 맵에 벽이 있으면?
					} else if (map[idx][idy] == 1) {
						// 현재 벽을 안 부쉈고, 벽을 부순 맵을 방문하지 않았다면?(이제 부술 예정이니깐 [1]맵을 검사)
						if (now.wall == 0 && !visited[idx][idy][1]) {
							q.add(new Now(idx, idy, cnt, 1)); // 큐에 넣고
							visited[idx][idy][1] = true; // 방문체크
						}
					}
				}
			}
		}
		System.out.println(-1); // 도달 안 했는데 while문 끝나버리면 -1 출력

	}
}
