package 스터디문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_3055_탈출_골드4 {
	static int[][] map;
	static int[][] water;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int H;
	static int W;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 땅:0, 물:0, 비버집:-1, 돌:-2
		H = sc.nextInt();
		W = sc.nextInt();
		map = new int[H][W];
		water = new int[H][W];
		visited = new boolean[H][W];
		int bex = 0;
		int bey = 0;
		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				char a = str.charAt(j);
				if (a == 'D') { // 비버집이면
					water[i][j] = -1;
					map[i][j] = -1;
					bex = i;
					bey = j;
				} else if (a == '*') {// 물이면
					water[i][j] = 1;
					q2.add(new int[] { i, j });
				} else if (a == 'S') {// 고슴도치면
					map[i][j] = 1;
				} else if (a == 'X') {// 돌이면
					water[i][j] = -2;
					map[i][j] = -2;
				}
			}
		}

		waterBFS(0, 0, q2);

		visited = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1) {
					mapBFS(i, j, q1);
				}
			}
		}
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(water[i][j] + " ");
//			}
//			System.out.println();
//		}

		if (map[bex][bey] == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(map[bex][bey] - 1);
		}

	}

	private static void mapBFS(int x, int y, Queue<int[]> q1) {
		q1.add(new int[] { x, y });
		visited[x][y] = true;
		while (!q1.isEmpty()) {
			x = q1.peek()[0];
			y = q1.peek()[1];
			q1.poll();
			for (int i = 0; i < 4; i++) {
				int idx = x + dr[i];
				int idy = y + dc[i];
				if (idx >= 0 && idy >= 0 && idx < H && idy < W) {
					if (map[idx][idy] != -1 && map[idx][idy] != -2 && water[idx][idy] > map[x][y] + 1&&!visited[idx][idy]) {
						map[idx][idy] = map[x][y] + 1;
						q1.add(new int[] { idx, idy });
						visited[idx][idy] = true;
					} else if (map[idx][idy] == -1 && !visited[idx][idy]) {
						map[idx][idy] = map[x][y] + 1;
						visited[idx][idy] = true;
						return;
					} else if(water[idx][idy]==0 && !visited[idx][idy] && map[idx][idy] != -1 && map[idx][idy] != -2 ) {
						map[idx][idy] = map[x][y] + 1;
						q1.add(new int[] { idx, idy });
						visited[idx][idy] = true;
					}
				}
			}
		}

	}

	private static void waterBFS(int x, int y, Queue<int[]> q2) {
		while (!q2.isEmpty()) {
			x = q2.peek()[0];
			y = q2.peek()[1];
			visited[x][y] = true;
			q2.poll();
			for (int i = 0; i < 4; i++) {
				int idx = x + dr[i];
				int idy = y + dc[i];
				if (idx >= 0 && idy >= 0 && idx < H && idy < W) {
					if (water[idx][idy] == 0 && !visited[idx][idy]) {
						water[idx][idy] = water[x][y] + 1;
						q2.add(new int[] { idx, idy });
						visited[idx][idy] = true;
					}
				}
			}
		}
	}
}
