package 단계별문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.SourceTree;

public class baek_7569_토마토_골드5 {
	static int N;
	static int M;
	static int H;
	// 토마토 저장
	static int[][][] map;
	// 결과의 날짜를 저장
	static int[][][] result;
	// 방문여부 쳌
	static boolean[][][] visited;
	// 사방탐색을 위한
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { -1, 0, 1, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	// int[] 저장 가능한 큐 생성
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[M][N][H];
		result = new int[M][N][H];
		visited = new boolean[M][N][H];
		// 맵의 정보를 map과 result에 같이 저장
		for (int l = 0; l < H; l++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j][l] = sc.nextInt();
					result[i][j][l] = map[i][j][l];
				}
			}
		}
		for (int l = 0; l < H; l++) {
			for (int i = 0; i < M ; i++) {
				for (int j = 0; j < N; j++) {
					// false고 1이면 큐에다가 그 좌표를 우선 저장해놓는다.
					// 이래야 1이 여러 개 있어도 동시에 탐색이 가능.
					if (!visited[i][j][l] && map[i][j][l] == 1) {
						q.add(new int[] { j, i, l });
					}
				}
			}
		}
		BFS();
		// 최댓값 판단
		int max = Integer.MIN_VALUE;
		// 0이 있는지 판단하기 위한 플래그
		boolean flag = true;
		for (int l = 0; l < H; l++) {
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					// 맥스 교체
					if (max < result[i][j][l])
						max = result[i][j][l];
					// 만약에 0이 있으면 불가능한 거니깐 false로 바꿈
					if (result[i][j][l] == 0)
						flag = false;
				}
			}
		}

		if (flag == false)
			System.out.println(-1);
		else
			System.out.println(max - 1);
//		for (int l = 0; l < H; l++) {
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(result[i][j][l] + " ");
//				}
//				System.out.println();
//			}
//		}

	}

	public static void BFS() {
		while (!q.isEmpty()) {
			// 좌표 뽑아냄.
			int x = q.peek()[0];
			int y = q.peek()[1];
			int h = q.peek()[2];
			// true로 바꾸고
			visited[y][x][h] = true;
			// 없앤다.
			q.poll();
			// 사방탐색
			for (int i = 0; i < 6; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				int ch = h + dh[i];
				// 경계값 확인하고
				if (cx >= 0 && cy >= 0 && cx < N && cy < M && ch>=0 && ch<H) {
					// false고 0이면
					if (!visited[cy][cx][ch] && map[cy][cx][ch] == 0) {
						// 경로에 1씩 더해준다. 이전 값에서 1씩 더해줘서 최적 루트 판단 가능.
						result[cy][cx][ch] = result[y][x][h] + 1;
						map[cy][cx][ch] = 1;

						q.add(new int[] { cx, cy, ch });
					}
				}
			}
		}
	}
}
