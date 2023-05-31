package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.SourceTree;

public class baek_7576_토마토_골드5 {
	static int N;
	static int M;
	// 토마토 저장
	static int[][] map;
	// 결과의 날짜를 저장
	static int[][] result;
	// 방문여부 쳌
	static boolean[][] visited;
	// 사방탐색을 위한
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	// int[] 저장 가능한 큐 생성
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[M][N];
		result = new int[M][N];
		visited = new boolean[M][N];
		// 맵의 정보를 map과 result에 같이 저장
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				result[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// false고 1이면 큐에다가 그 좌표를 우선 저장해놓는다.
				// 이래야 1이 여러 개 있어도 동시에 탐색이 가능.
				if (!visited[i][j] && map[i][j] == 1) {
					q.add(new int[] { j, i });
				}
			}
		}
		BFS();
		// 최댓값 판단
		int max = Integer.MIN_VALUE;
		// 0이 있는지 판단하기 위한 플래그
		boolean flag = true;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 맥스 교체
				if (max < result[i][j])
					max = result[i][j];
				// 만약에 0이 있으면 불가능한 거니깐 false로 바꿈
				if (result[i][j] == 0)
					flag = false;
			}
		}
		
		if(flag == false) System.out.println(-1);
		else System.out.println(max-1);
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(result[i][j]+" ");
			}System.out.println();
		}

	}

	public static void BFS() {
		while (!q.isEmpty()) {
			// 좌표 뽑아냄.
			int x = q.peek()[0];
			int y = q.peek()[1];
			// true로 바꾸고
			visited[y][x] = true;
			// 없앤다.
			q.poll();
			// 사방탐색
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				// 경계값 확인하고
				if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
					// false고 0이면
					if (!visited[cy][cx] && map[cy][cx] == 0) {
						// 경로에 1씩 더해준다. 이전 값에서 1씩 더해줘서 최적 루트 판단 가능.
						result[cy][cx] = result[y][x] + 1;
						map[cy][cx] = 1;

						q.add(new int[] { cx, cy });
					}
				}
			}
		}
	}
}
