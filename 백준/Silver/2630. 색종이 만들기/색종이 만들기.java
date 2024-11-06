import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] paper;
	static int blue, white = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(bf.readLine());
		paper = new int[size][size];

		for (int i = 0; i < size; i++) {
			String[] sa = bf.readLine().split(" ");
			for (int j = 0; j < size; j++) {
				paper[i][j] = Integer.parseInt(sa[j]);
			}
		}

		dfs(0, 0, size);

		System.out.println(white);
		System.out.println(blue);

	}

	private static void dfs(int y, int x, int checkSize) {
		// true 경우는 해당 칸이 전부 일치하는 색
		if (check(y, x, checkSize)) {
			if (paper[y][x] == 1) {
				blue++;
			} else {
				white++;
			}
		} else {
			dfs(y, x, checkSize / 2);
			dfs(y + checkSize / 2, x, checkSize / 2);
			dfs(y, x + checkSize / 2, checkSize / 2);
			dfs(y + checkSize / 2, x + checkSize / 2, checkSize / 2);
		}
	}

	private static boolean check(int y, int x, int checkSize) {
		// 초기 값
		int init = paper[y][x];

		for (int i = y; i < y + checkSize; i++) {
			for (int j = x; j < x + checkSize; j++) {
				if (init != paper[i][j])
					return false;
			}
		}

		return true;
	}

}