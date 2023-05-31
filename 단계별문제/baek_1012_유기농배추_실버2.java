package 단계별문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baek_1012_유기농배추_실버2 {
	static int M;
	static int N;
	static int E;
	static boolean[][] visited;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int count = 0;
		for (int tc = 1; tc <= T; tc++) {
			count = 0;
			M = sc.nextInt();
			N = sc.nextInt();
			E = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<E; i++) {
				int p1 = sc.nextInt();
				int p2 = sc.nextInt();
				map[p2][p1] = 1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1&&!visited[i][j]) {
						BFS(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}

	public static void BFS(int y, int x) {
		// int배열만 담을 수 있는 큐 생성
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x, y}); // 큐에 int[]배열을 생성해서 x랑 y를 담는다.
		
		while(!q.isEmpty()) {
			// x랑 y를 뽑아내서 visited를 true로 만들고 poll 해서 버린다.
			x = q.peek()[0];
			y = q.peek()[1];
			visited[y][x] = true;
			q.poll();
			// 사방을 탐색하기 위해.
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				// 범위 안에 있고
				if(cx>=0 && cy>=0 && cx<M && cy<N) {
					// visited가 false고 map이 1이면!
					if(!visited[cy][cx] && map[cy][cx]==1) {
						// 큐에 추가하고 true로 만든다.
						q.add(new int[] {cx,cy});
						visited[cy][cx] = true;
					}
				}
			}
		}
	}
}
