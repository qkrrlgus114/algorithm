import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_3055_탈출_골드4 {
	static int W;
	static int H;
	static int[][] map; // 원본은 갖고 있으려고
	static int[][] result; // 경로를 저장
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt = 0;
	static Queue<int[]> q1 = new LinkedList<>(); // 고슴도치 좌표
	static Queue<int[]> q2 = new LinkedList<>(); // 물 좌표(1)
	static Queue<int[]> q3 = new LinkedList<>(); // 물 좌표(2)
	static boolean flag = true; // 물이 최대 고슴도치 경로를 잡았는지 판단
	static int max = 0; // 경로 최대값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		int beaverx = 0; // 비버 집의 위치
		int beavery = 0;
		// 1:고슴도치, 0:땅, -1:물, -2:비버, -3:돌
		map = new int[H][W];
		result = new int[H][W];
		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				char a = str.charAt(j);
				if (a == 'D') {
					beaverx = i;
					beavery = j;
					map[i][j] = -2;
					result[i][j] = -2;
				} else if (a == '.') {
					map[i][j] = 0;
					result[i][j] = 0;
				} else if (a == '*') {
					q3.add(new int[] { i, j });
					map[i][j] = -1;
					result[i][j] = -1;
				} else if (a == 'S') {
					map[i][j] = 1;
					result[i][j] = 1;
				} else if (a == 'X') {
					map[i][j] = -3;
					result[i][j] = -3;
				}
			}
		}
		// 고슴도치 위치 저장
		int a = 0;
		int b = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1) {
					a = i;
					b = j;
				}
			}
		}
		// BFS돌린다!
		BFS(a, b);
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.println();
//		}
		if(result[beaverx][beavery]!=0) { // 비버의 좌표가 0이 아니면? 최댓값이 있다는 소리니 그 위치 출력
			System.out.println(result[beaverx][beavery]-1);
		}else { // 0이면 도달하지 못했다는 소리니 
			System.out.println("KAKTUS");
		}

	}

	private static void BFS(int x, int y) {
		q1.add(new int[] { x, y });
		while (!q1.isEmpty()) {
			// Q3물이 꽉차있으면 Q2물로 옮긴다.
			while (!q3.isEmpty()) {
				q2.add(q3.poll());
			}
			int size = q1.size(); // 고슴도치의 사이즈
			for (int w = 0; w < size; w++) {
				x = q1.peek()[0];
				y = q1.peek()[1];
				q1.poll();

				for (int i = 0; i < 4; i++) { //사방탐색
					int idr = x + dr[i];
					int idc = y + dc[i];
					// 범위 내에 있고 물(-1)이 없으면
					if (idr >= 0 && idc >= 0 && idr < H && idc < W && result[idr][idc] != -1) {
						// 그냥 땅이면
						if (result[idr][idc] == 0) {
							result[idr][idc] = result[x][y] + 1; // 이전 값에서 +1
							if (max < result[idr][idc]) // 현재까지 최대 값 갱신
								max = result[idr][idc];
							q1.add(new int[] { idr, idc });
						} else if (result[idr][idc] == -2) { // 비버집에 도착했다면
							result[idr][idc] = result[x][y]+1; // 그 자리에 이전 값 넣고
							return; // 리턴
						}

					}
				}
			}
			while (!q2.isEmpty()) { // Q2인 물이 존재하면
				int r = q2.peek()[0];
				int c = q2.peek()[1];
				q2.poll();
				for (int i = 0; i < 4; i++) { // 사방탐색
					int idr = r + dr[i];
					int idc = c + dc[i];
					// 물이 내부에 존재하고 이동하는 곳이 물(-1)이 아니면
					if (idr >= 0 && idc >= 0 && idr < H && idc < W && result[idr][idc] != -1) {
						if (result[idr][idc] >= 0) { // 0 이상이면 고슴도치의 좌표니깐
							result[idr][idc] = -1; // 물로 덮어버리고
							q3.add(new int[] { idr, idc });
						} else if (result[idr][idc] == max) { // 맥스값을 만났다면?(즉 고슴도치 최대 경로를 잡아버리면)
							flag = false; // false로 만들고
							return; // 리턴
						}
					}
				}
			}
		}
		return;

	}
}