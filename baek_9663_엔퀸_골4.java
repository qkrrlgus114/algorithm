import java.util.Scanner;

public class baek_9663_엔퀸_골4 {
	static int N;
	static int[][] map;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		count = 0;
		N = sc.nextInt();
		map = new int[N][N];
		perm(0);
		System.out.println(count);

	}

	public static void perm(int queen) {
		// 종료
		if (queen == N) {
			count++;
			return;
		}
		// 재귀
		for (int j = 0; j < N; j++) {
			if (check(queen, j)) {
				map[queen][j] = 1;
				perm(queen + 1);
				map[queen][j] = 0;
			}
		}
	}

	public static boolean check(int r, int c) {
		// 세로 검사
		for (int j = r; j >= 0; j--) {
			if (map[j][c] == 1)
				return false;
		}
		// 왼쪽 대각선 검사
		for (int j = c, i = r; j >= 0; i--, j--) {
			if (j - 1 >= 0 && i - 1 >= 0 && map[i - 1][j - 1] == 1)
				return false;
		}

		// 오른쪽 대각선 검사
		for (int j = c, i = r; i >= 0; i--, j++) {
			if (i - 1 >= 0 && j + 1 < map.length && map[i - 1][j + 1] == 1)
				return false;
		}

		return true;

	}
}
