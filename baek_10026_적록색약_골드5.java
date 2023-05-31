import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_10026_적록색약_골드5 {
	static int N;
	static boolean[][] visited;
	static boolean[][] realvisited;
	static int[][] map;
	static int[][] result;
	static int[][] realresult;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int count = 0;
	static int realcount = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		result = new int[N][N];
		visited = new boolean[N][N];
		realresult = new int[N][N];
		realvisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'R') {
					map[i][j] = 1;
				} else if (str.charAt(j) == 'B') {
					map[i][j] = 2;
				} else if (str.charAt(j) == 'G') {
					map[i][j] = 3;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					BFS(i, j);
				} else if (map[i][j] == 2) {
					BBFS(i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				BBBFS(i, j);
			}
		}
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (realresult[i][j] == 1)
					cnt2++;
				if (result[i][j] == 0)
					cnt1++;
				if (realresult[i][j] == realcount)
					cnt2++;
			}
		}
		System.out.println(cnt2); // 적록색약이 아닌 사람이 보는 구역 개수 출력
		System.out.println(cnt1); // 적록색약인 사람이 보는 구역 개수 출력
	}

	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			for (int i = 0; i < 4; i++) {
				int idx = x + dr[i];
				int idy = y + dc[i];
				if (idx >= 0 && idy >= 0 && idx < N && idy < N) {
					if (!visited[idx][idy] && (map[idx][idy] == 1 || map[idx][idy] == 3)) {
						visited[idx][idy] = true;
						result[x][y] = 0;
						result[idx][idy] = 0;
						q.add(new int[] { idx, idy });
					}
				}
			}
		}
		count++;

	}

	public static void BBFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			for (int i = 0; i < 4; i++) {
				int idx = x + dr[i];
				int idy = y + dc[i];
				if (idx >= 0 && idy >= 0 && idx < N && idy < N) {
					if (!visited[idx][idy] && map[idx][idy] == 2) {
						visited[idx][idy] = true;
						result[x][y] = 4;
						result[idx][idy] = 4;
						q.add(new int[] { idx, idy });
					}
				}
			}
		}
		count++;
	}

	public static void BBBFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		realvisited[x][y] = true;
		realresult[x][y] = realcount;

		while (!q.isEmpty()) {
			x = q.peek()[0];
			y = q.peek()[1];
			q.poll();
			for (int i = 0; i < 4; i++) {
				int idx = x + dr[i];
				int idy = y + dc[i];
				if (idx >= 0 && idy >= 0 && idx < N && idy < N) {
					if (!realvisited[idx][idy] && map[x][y] == map[idx][idy]) {
						realvisited[idx][idy] = true;
						realresult[idx][idy] = realcount;
						q.add(new int[] { idx, idy });
					}
				}
			}
		}
		realcount++;
	}
}
