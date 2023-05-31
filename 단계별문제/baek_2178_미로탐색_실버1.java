package 단계별문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2178_미로탐색_실버1 {
	static int N;
	static int M;
	static int[][] map; 
	static int[][] result; // 결과 길이를 저장하는 배열 
	// 사방탐색을 위한 델타
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	// 방문 확인
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		result = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		// bfs 0,0부터 돌린다.
		BFS(0,0);
		System.out.println(result[N-1][M-1]);
	}
	
	public static void BFS(int x, int y) {
		// int 배열만 받는 큐 생성
		Queue<int[]> q = new LinkedList<int[]>();
		// 배열 객체 만들어서 x랑 y 집어넣기.
		q.add(new int[] {x, y});
		// 처음에는 1부터 시작
		result[y][x] = 1;
		while(!q.isEmpty()) {
			// 우선 임시로 꺼내서 지정
			x = q.peek()[0];
			y = q.peek()[1];
			// 그걸 true로 만들고
			visited[y][x] = true;
			// 빼낸다.
			q.poll();
			// 사방탐색
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				// 범위 안에 있고
				if(cx>=0 && cy>=0 && cx<M && cy<N) {
					// 길이 있으며, false일 경우
					if(map[cy][cx]==1 && !visited[cy][cx]) {
						// 이전 루트에서 1을 더해서 저장한다. 이래야 갈림길에서도 이전 값의 +1만 저장된다.
						result[cy][cx] = result[y][x] + 1;
						// 만약에 해당 위치에 도착하면 true만들고 return
						if(cy==N-1 && cx==M-1) {
							visited[cy][cx] = true;
							return;
						}
						// 또 큐에 객체로 더해주고 true
						q.add(new int[] {cx, cy});
						visited[cy][cx] = true;
					}
				}
			}
			
		}
	}
}


