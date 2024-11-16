import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int N;
	static char[][] graph;
	static boolean[][] visited;
	// 상하좌우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// 단지 내 집의 수를 저장 할 리스트
		List<Integer> groupHouseCntList = new ArrayList<>();
		// 단지의 수
		int groupCnt = 0;
		N = Integer.parseInt(bf.readLine());

		graph = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = bf.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || graph[i][j] != '1')
					continue;

				visited[i][j] = true;
				// 단지 내 집의 수
				int groupHouseCnt = bfs(i, j);
				groupCnt++;
				groupHouseCntList.add(groupHouseCnt);
			}
		}

		Collections.sort(groupHouseCntList);

		StringBuilder sb = new StringBuilder();
		sb.append(groupCnt).append("\n");
		for (Integer cnt : groupHouseCntList) {
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);

	}

	public static int bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x});
		int houseCnt = 1;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			y = temp[0];
			x = temp[1];

			for (int i = 0; i < 4; i++) {
				int ndy = dy[i] + y;
				int ndx = dx[i] + x;
				if (ndy < 0 || ndx < 0 || ndy >= N || ndx >= N)
					continue;
				if (visited[ndy][ndx] || graph[ndy][ndx] != '1')
					continue;

				visited[ndy][ndx] = true;
				houseCnt++;
				q.add(new int[] {ndy, ndx});
			}
		}

		return houseCnt;
	}
}