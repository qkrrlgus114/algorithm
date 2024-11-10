import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N, M;
	static boolean[][] visited;
	static char[][] graph;

	// 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] sa = bf.readLine().split(" ");
		N = Integer.parseInt(sa[0]);
		M = Integer.parseInt(sa[1]);

		graph = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			graph[i] = bf.readLine().toCharArray();
		}

		// 도연이의 초기 위치
		int doY = 0;
		int doX = 0;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(graph[i][j] == 'I'){
					doX = j;
					doY = i;
					break outer;
				}
			}
		}

		int visitedCnt = bfs(doY, doX);

		System.out.println(visitedCnt != 0 ? visitedCnt : "TT");

	}

	public static int bfs(int y, int x){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y, x});
		visited[y][x] = true;
		int visitedCnt = 0;

		while(!q.isEmpty()){
			int[] temp = q.poll();
			y = temp[0];
			x = temp[1];
			for(int i=0; i<4; i++){
				int ndx = x + dx[i];
				int ndy = y + dy[i];

				if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M || graph[ndy][ndx] == 'X' || visited[ndy][ndx]){
					continue;
				}

				if(graph[ndy][ndx] == 'P') visitedCnt++;
				visited[ndy][ndx] = true;
				q.add(new int[]{ndy, ndx});
			}
		}

		return visitedCnt;
	}

}