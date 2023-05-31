import java.util.Scanner;

import sun.print.resources.serviceui;

public class swea_N_Queen {
	static int[][] map;
	static int count;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			count = 0;
			N = sc.nextInt();
			map = new int[N][N];
			perm(0);
			System.out.printf("#%d %d\n",tc,count);
		}
	}

	public static void perm(int queen) { // 퀸을 행으로 둔다.
		if (queen == N) {
			count++;
			return;
		}

		for (int j = 0; j < N; j++) {
			if (search(queen, j)) {
				map[queen][j] = 1;
				perm(queen + 1);
				map[queen][j] = 0;
			}
		}
		return;
	}

	public static boolean search(int i, int j) {
		// 세로
		for (int r = i; r >= 0; r--) {
			if (map[r][j] == 1)
				return false;
		}
		// 왼쪽 대각선 위
		for (int r = i, c = j; r >= 0 && c >= 0; c--, r--) {
			if (map[r][c] == 1)
				return false;
		}
		// 오른쪽 대각선 위
		for (int r = i, c = j; c < map.length && r >= 0; r--, c++) {
			if (map[r][c] == 1)
				return false;
		}

		return true;
	}
}
