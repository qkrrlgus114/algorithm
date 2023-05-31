import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_탈주범검거 {
	static int H; // 세로
	static int W; // 가로
	static int R; // 맨홀 세로 위치
	static int C; // 맨홀 가로 위치
	static int L; // 시간
	static int map[][]; // 맵
	// 1~7번까지 파이프 (상 하 좌 우) 순으로 배치
	static int[][] dr = { {}, { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { -1, 0, 0, 0 } };
	static int[][] dc = { {}, { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
			{ 0, 0, -1, 0 }, { 0, 0, -1, 0 } };
	static int[][] visited; // 방문체크
	static int idx;
	static int idy;
	static int[][] result; // 결과 배열
	static int loc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			map = new int[H][W];
			result = new int[H][W];
			visited = new int[H][W];
			// 입력
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
					// 맵이 0이 아니면 방문체크에 -1로 입력
					if (map[i][j] != 0) {
						visited[i][j] = -1;
					}
				}
			}
			// 맨홀 위치 찾기
			int hole = map[R][C];
			// 맨홀의 좌표, 이동 횟수, 맨홀 밑에 파이프 번호
			BFS(R, C, 1, hole);
			int cnt = 0;

			// 해당 좌표가 0이 아니고 L이하이면 전부 카운트
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (result[i][j] <= L && result[i][j] != 0)
						cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);

		}
	}

	public static void BFS(int x, int y, int move, int pipe) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y, pipe }); // x,y,파이프 순으로 큐에 넣음.
		visited[x][y] = 1; // 1이면 방문처리
		result[x][y] = move; // 결과 배열에 우선 1 넣기.

		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			pipe = q.peek()[2]; // 전부 뽑아내고
			q.poll(); // 버린다.
			for (int j = 0; j < 4; j++) { // 상하좌우 탐색
				idx = x + dr[pipe][j];
				idy = y + dc[pipe][j];
				// 범위 내에 있고 방문 가능하면
				if (idx >= 0 && idy >= 0 && idx < H && idy < W && visited[idx][idy] == -1) {
					loc = map[idx][idy]; // 이동하는 위치
					switch (pipe) {
					case 1:
						// 해당 상,하,좌,우에 이어지는 파이프가 있다면
						if (j == 0 && (loc == 1 || loc == 2 || loc == 5 || loc == 6)) {
							visited[idx][idy] = 1; // 방문체크 하고
							q.add(new int[] { idx, idy, loc }); // 큐에 해당 위치와 파이프 넣음.
							result[idx][idy] = result[x][y] + 1; // 결과 배열에는 이전 위치+1로 설정
						} else if (j == 1 && (loc == 1 || loc == 2 || loc == 4 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 2 && (loc == 1 || loc == 3 || loc == 4 || loc == 5)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 3 && (loc == 1 || loc == 3 || loc == 6 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						}
						break;
					case 2:
						if (j == 0 && (loc == 1 || loc == 2 || loc == 5 || loc == 6)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 1 && (loc == 1 || loc == 2 || loc == 4 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						}
						break;
					case 3:
						if (j == 2 && (loc == 1 || loc == 3 || loc == 4 || loc == 5)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 3 && (loc == 1 || loc == 3 || loc == 6 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						}
						break;
					case 4:
						if (j == 0 && (loc == 1 || loc == 2 || loc == 5 || loc == 6)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 3 && (loc == 1 || loc == 3 || loc == 6 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						}
						break;
					case 5:
						if (j == 1 && (loc == 1 || loc == 2 || loc == 4 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 3 && (loc == 1 || loc == 3 || loc == 6 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						}
						break;
					case 6:
						if (j == 1 && (loc == 1 || loc == 2 || loc == 4 || loc == 7)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 2 && (loc == 1 || loc == 3 || loc == 4 || loc == 5)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						}
						break;
					case 7:
						if (j == 0 && (loc == 1 || loc == 2 || loc == 5 || loc == 6)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						} else if (j == 2 && (loc == 1 || loc == 3 || loc == 4 || loc == 5)) {
							visited[idx][idy] = 1;
							q.add(new int[] { idx, idy, loc });
							result[idx][idy] = result[x][y] + 1;
						}
						break;
					default:
						break;
					}
				}
			}
		}
	}
}