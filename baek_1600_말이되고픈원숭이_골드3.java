import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1600_말이되고픈원숭이_골드3 {
	// 상하좌우, 1시부터 진행
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] mr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] mc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int H;
	static int W;
	static int K; // 말 이동 횟수
	static boolean[][][] visited; 
	static int[][] map;

	public static class Now {
		int x;
		int y;
		int move;
		int horse;

		public Now(int x, int y, int move, int horse) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.horse = horse;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		visited = new boolean[H][W][K + 1];
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		BFS(0, 0);
	}

	public static void BFS(int x, int y) {
		Queue<Now> q = new LinkedList<Now>();
		q.add(new Now(x, y, 0, K));
		visited[x][y][K] = true;
		while (!q.isEmpty()) {
			Now now = q.poll();
			x = now.x;
			y = now.y;

			if (x == H - 1 && y == W - 1) { // 도착하면 출력하고 리턴
				System.out.println(now.move);
				return;
			}

			for (int i = 0; i < 4; i++) { // 상하좌우부터 봄
				int idx = x + dr[i];
				int idy = y + dc[i];
				// 범위 안에 있으면
				if (idx >= 0 && idy >= 0 && idx < H && idy < W) {
					if (!visited[idx][idy][now.horse] && map[idx][idy] == 0) {
						q.add(new Now(idx, idy, now.move + 1, now.horse));
						visited[idx][idy][now.horse] = true;
					}
				}
			}

			if (now.horse == 0) { // 말 횟수가 0이 되면 말로 이동 못함.
				continue;
			}

			for (int i = 0; i < 8; i++) {
				int idx = x + mr[i];
				int idy = y + mc[i];
				if (idx >= 0 && idy >= 0 && idx < H && idy < W) {
					if (!visited[idx][idy][now.horse-1] && map[idx][idy] == 0) { // 이동한 부분을 확인하니깐 -1로 확인
						q.add(new Now(idx, idy, now.move + 1, now.horse-1));
						visited[idx][idy][now.horse-1] = true;
					}
				}
			}

		}
		System.out.println(-1);
		return;
	}
}
