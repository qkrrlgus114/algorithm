
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M, num;
	static int[][] graph;
	static boolean[][] visited;
	// 상 하 좌 우
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			String[] sa = bf.readLine().split(" ");
			M = Integer.parseInt(sa[0]);
			N = Integer.parseInt(sa[1]);
			num = Integer.parseInt(sa[2]);

			graph = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < num; i++) {
				sa = bf.readLine().split(" ");
				int W = Integer.parseInt(sa[0]);
				int H = Integer.parseInt(sa[1]);

				graph[H][W] = 1;
			}

			int result = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] || graph[i][j] == 0) continue;
					bfs(i, j);
					result++;
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int y, int x){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y, x});
		visited[y][x] = true;

		while(!q.isEmpty()){
			int[] temp = q.poll();
			y = temp[0];
			x = temp[1];

			for(int i=0; i<4; i++){
				int ndx = dx[i] + x;
				int ndy = dy[i] + y;
				if(ndx < 0 || ndy < 0 || ndy >= N || ndx >= M) continue;
				if(visited[ndy][ndx] || graph[ndy][ndx] == 0) continue;
				visited[ndy][ndx] = true;
				q.add(new int[]{ndy, ndx});
			}
		}
	}

}