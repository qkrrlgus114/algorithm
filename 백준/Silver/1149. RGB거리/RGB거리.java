import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] paints;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		paints = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			String[] sa = bf.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				paints[i][j] = Integer.parseInt(sa[j]);
			}
		}

		System.out.println(dfs(-1, 0));
	}

	public static int dfs(int pre, int idx) {
		if (idx == N) {
			return 0;
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			if (i == pre) {
				continue;
			}
			if (dp[idx][i] == Integer.MAX_VALUE) {
				dp[idx][i] = paints[idx][i] + dfs(i, idx + 1);
			}
			answer = Math.min(answer, dp[idx][i]);
		}

		return answer;
	}
}
