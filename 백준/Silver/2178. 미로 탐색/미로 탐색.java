import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M;
	static char[][] miro;
	static boolean[][] visited;
	// 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		N = Integer.parseInt(sa[0]);
		M = Integer.parseInt(sa[1]);

		visited = new boolean[N][M];
		miro = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] array = bf.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				miro[i][j] = array[j];
			}
		}

		int step = bfs();

		System.out.println(step);

	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 1});
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int y = temp[0];
			int x = temp[1];
			int step = temp[2];

			if (y == N - 1 && x == M - 1) {
				return step;
			}

			for (int i = 0; i < 4; i++) {
				int ndy = y + dy[i];
				int ndx = x + dx[i];

				// 미로의 배열을 벗어나는지 확인
				if (ndy < 0 || ndx < 0 || ndy >= N || ndx >= M)
					continue;
				// 이미 도착했는지
				if (visited[ndy][ndx])
					continue;
				// 미로의 좌표가 0인지
				if (miro[ndy][ndx] == '0')
					continue;

				visited[ndy][ndx] = true;
				q.add(new int[] {ndy, ndx, step + 1});
			}
		}

		return 0;
	}
}