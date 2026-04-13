import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] grapeDrinks;
	static Integer[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		grapeDrinks = new int[N];
		memo = new Integer[N][3];
		for (int i = 0; i < N; i++) {
			grapeDrinks[i] = Integer.parseInt(bf.readLine());
		}

		dfs(0, 0);
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int idx, int cnt) {
		if (idx == N) {
			return 0;
		}

		if (memo[idx][cnt] != null) {
			return memo[idx][cnt];
		}

		// 현재 잔 안마심
		int result = dfs(idx + 1, 0);

		// 현재ㅔ 잔 마심
		if (cnt < 2) {
			result = Math.max(result, dfs(idx + 1, cnt + 1) + grapeDrinks[idx]);
		}

		return memo[idx][cnt] = result;
	}
}
